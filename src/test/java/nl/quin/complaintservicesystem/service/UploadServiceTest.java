package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.model.Upload;
import nl.quin.complaintservicesystem.repository.UploadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UploadServiceTest {

    @Mock
    Upload upload;

    @Mock
    UploadRepository uploadRepository;

    @Captor
    ArgumentCaptor<Upload> uploadCaptor;

    @Test
    public void createUploadTest() {
        upload = new Upload();
        upload.setId(1L);
        upload.setOrderNumberUpload("777");

        uploadRepository.save(upload);

        verify(uploadRepository, times(1)).save(uploadCaptor.capture());
        var upload1 = uploadCaptor.getValue();

        assertThat(upload1.getOrderNumberUpload()).isEqualTo("777");
        assertThat(upload1.getId()).isEqualTo(1);
    }

}