package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;
import nl.quin.complaintservicesystem.model.Upload;
import nl.quin.complaintservicesystem.repository.UploadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UploadServiceTest {

    @InjectMocks
    UploadService uploadService;

    @Mock
    Upload upload;

    @Mock
    UploadRepository uploadRepository;

    @Captor
    ArgumentCaptor<Upload> uploadCaptor;

    @Test
    void getAllUploadTest() {

        // ARRANGE
        List<Upload> uploads = new ArrayList();
        uploads.add(new Upload(1L, "111", "aaa"));
        uploads.add(new Upload(2L,"222", "bbb"));
        uploads.add(new Upload(3L,"333", "ccc"));

        // ACT
        given(uploadRepository.findAll()).willReturn(uploads);

        // ASSERT
        Iterable<Upload> expected = uploadService.getFiles();
        assertEquals(expected,uploads);
    }

    @Test
    void getReceiptUploadByIdThrowExceptionTest() {

        // ACT
        when(uploadRepository.findById(1L)).thenReturn(Optional.empty());

        // ASSERT
        assertThrows(RecordNotFoundException.class, () -> {
            uploadService.getFileById(1L);

        });
    }

    @Test
    void getUploadIsNullErrorTest() {

        // ARRANGE
        String ordernumber = null;

        // ACT
        Mockito
                .when(uploadRepository
                        .findById(1L)).thenReturn(Optional.of(upload));

        // ASSERT
        assertNull(ordernumber, "ordernumber should not be found");
    }

    @Test
    public void createUploadTest() {

        // ARRANGE
        upload = new Upload();
        upload.setId(1L);
        upload.setOrderNumberUpload("777");

        uploadRepository.save(upload);

        // ACT
        verify(uploadRepository, times(1)).save(uploadCaptor.capture());
        var upload1 = uploadCaptor.getValue();

        // ASSERT
        assertThat(upload1.getOrderNumberUpload()).isEqualTo("777");
        assertThat(upload1.getId()).isEqualTo(1);
    }

    @Test
    public void updateUploadDeleteThrowExceptionTest() {

        // ASSERT
        assertThrows(RecordNotFoundException.class, () -> uploadService.getFileById(1L));
    }

}