package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;
import nl.quin.complaintservicesystem.model.ReceiptUpload;
import nl.quin.complaintservicesystem.repository.ReceiptUploadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ReceiptUploadServiceTest {

    @Mock
    ReceiptUpload receiptUpload;

    @InjectMocks
    ReceiptUploadService receiptUploadService;

    @Mock
    ReceiptUploadRepository receiptUploadRepository;

    @Captor
    ArgumentCaptor<ReceiptUpload> receiptUploadCaptor;

    @Test
    void testGetReceiptUploadByIdThrowException() {
        when(receiptUploadRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RecordNotFoundException.class, () -> {
            receiptUploadService.getFileById(1L);

        });
    }

    @Test
    public void createReceiptUploadTest() {
        receiptUpload = new ReceiptUpload();
        receiptUpload.setId(1L);
        receiptUpload.setOrdernumber("777");

        receiptUploadRepository.save(receiptUpload);

        verify(receiptUploadRepository, times(1)).save(receiptUploadCaptor.capture());
        var receiptUpload1 = receiptUploadCaptor.getValue();

        assertThat(receiptUpload1.getOrdernumber()).isEqualTo("777");
        assertThat(receiptUpload1.getId()).isEqualTo(1);
    }

    @Test
    public void updateReceiptUploadDeleteThrowExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> receiptUploadService.getFileById(1L));
    }

}
