package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.FileStorageException;
import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;

import nl.quin.complaintservicesystem.model.Upload;
import nl.quin.complaintservicesystem.payload.request.UploadRequestDto;
import nl.quin.complaintservicesystem.payload.response.UploadResponseDto;
import nl.quin.complaintservicesystem.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class UploadService {

    @Value("${app.upload.dir:${user.home}}")
    private String uploadDirectory;
    private final Path uploads = Paths.get("uploads");

    @Autowired
    private UploadRepository repository;

    @Autowired
    UserService username;

    public void init() {
        try {
            Files.createDirectory(uploads);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public Iterable<Upload> getFiles() {
        return repository.findAll();
    }

    public long uploadFile(UploadRequestDto uploadRequestDto) {

        MultipartFile file = uploadRequestDto.getFile();

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        Path copyLocation = this.uploads.resolve(file.getOriginalFilename());

        try {
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new FileStorageException("Could not store file " + originalFilename + ". Please try again!");
        }

        Upload newFileToStore = new Upload();
        newFileToStore.setFileName(originalFilename);
        newFileToStore.setLocation(copyLocation.toString());
        newFileToStore.setTitle(uploadRequestDto.getTitle());
        newFileToStore.setDescription(uploadRequestDto.getDescription());
        newFileToStore.setUploadedByUsername(username.getCurrentUserName());
        newFileToStore.setUploadedOnDate(Timestamp.valueOf(LocalDateTime.now()));
        Upload saved = repository.save(newFileToStore);

        return saved.getId();
    }

    public void deleteFile(long id) {
        Optional<Upload> stored = repository.findById(id);

        if (stored.isPresent()) {
            String filename = stored.get().getFileName();
            Path location = this.uploads.resolve(filename);
            try {
                Files.deleteIfExists(location);
            }
            catch (IOException ex) {
                throw new RuntimeException("File not found");
            }

            repository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    public UploadResponseDto getFileById(long id) {
        Optional<Upload> stored = repository.findById(id);

        if (stored.isPresent()) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand("download").toUri();

            UploadResponseDto responseDto = new UploadResponseDto();
            responseDto.setFileName(stored.get().getFileName());
            responseDto.setTitle(stored.get().getTitle());
            responseDto.setDescription(stored.get().getDescription());
            responseDto.setDownloadUri(uri.toString());
            responseDto.setUploadedByUserName(stored.get().getUploadedByUsername());
            responseDto.setUploadedOnDate(stored.get().getUploadedOnDate());
            return responseDto;
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    public boolean fileExistsById(long id) {
        return repository.existsById(id);
    }

    public Resource downloadFile(long id) {
        Optional<Upload> stored = repository.findById(id);

        if (stored.isPresent()) {
            String filename = stored.get().getFileName();
            Path path = this.uploads.resolve(filename);

            Resource resource = null;
            try {
                resource = new UrlResource(path.toUri());
                return resource;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else {
            throw new RecordNotFoundException();
        }

        return null;
    }

}