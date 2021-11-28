package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.ReceiptUpload;
import nl.quin.complaintservicesystem.payload.request.ReceiptUploadRequestDto;
import nl.quin.complaintservicesystem.payload.response.ReceiptUploadResponseDto;
import nl.quin.complaintservicesystem.service.ReceiptUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("receipt_upload")
@CrossOrigin
public class ReceiptUploadController {

    @Autowired
    ReceiptUploadService receiptUploadService;

    @GetMapping("/files")
    public ResponseEntity<Object> getFiles() {
        Iterable<ReceiptUpload> files = receiptUploadService.getFiles();
        return ResponseEntity.ok().body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<Object> getFileInfo(@PathVariable long id) {
        ReceiptUploadResponseDto response = receiptUploadService.getFileById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/files/{id}/download")
    public ResponseEntity downloadFile(@PathVariable long id) {
        Resource resource = receiptUploadService.downloadFile(id);
        String mediaType = "application/octet-stream";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mediaType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping(value = "/files",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> uploadFile(ReceiptUploadRequestDto method1Dto) {
        long newId = receiptUploadService.uploadFile(method1Dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @DeleteMapping("/files/{id}")
    public ResponseEntity<Object> deleteFile(@PathVariable long id) {
        receiptUploadService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }

}
