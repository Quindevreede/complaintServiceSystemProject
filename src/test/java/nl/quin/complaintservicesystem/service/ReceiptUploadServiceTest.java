package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;
import nl.quin.complaintservicesystem.model.ReceiptUpload;
import nl.quin.complaintservicesystem.repository.ReceiptUploadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
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
    void getAllReceiptUploadTest() {

        // ARRANGE
        List<ReceiptUpload> receiptUploads = new ArrayList();
        receiptUploads.add(new ReceiptUpload(1L, "111"));
        receiptUploads.add(new ReceiptUpload(2L,"222"));
        receiptUploads.add(new ReceiptUpload(3L,"333"));

        // ACT
        given(receiptUploadRepository.findAll()).willReturn(receiptUploads);

        // ASSERT
        Iterable<ReceiptUpload> expected = receiptUploadService.getFiles();
        assertEquals(expected,receiptUploads);
    }

    @Test
    void getReceiptUploadByIdThrowExceptionTest() {

        // ACT
        when(receiptUploadRepository.findById(1L)).thenReturn(Optional.empty());

        // ASSERT
        assertThrows(RecordNotFoundException.class, () -> {
            receiptUploadService.getFileById(1L);

        });
    }

    @Test
    void getReceiptUploadIsNullErrorTest() {

        // ARRANGE
        String ordernumber = null;

        // ACT
        Mockito
                .when(receiptUploadRepository
                        .findById(1L)).thenReturn(Optional.of(receiptUpload));

        // ASSERT
        assertNull(ordernumber, "ordernumber should not be found");
    }

    @Test
    public void createReceiptUploadTest() {

        // ARRANGE
        receiptUpload = new ReceiptUpload();
        receiptUpload.setId(1L);
        receiptUpload.setOrdernumber("777");

        receiptUploadRepository.save(receiptUpload);

        // ACT
        verify(receiptUploadRepository, times(1)).save(receiptUploadCaptor.capture());
        var receiptUpload1 = receiptUploadCaptor.getValue();

        // ASSERT
        assertThat(receiptUpload1.getOrdernumber()).isEqualTo("777");
        assertThat(receiptUpload1.getId()).isEqualTo(1);
    }

    @Test
    public void updateReceiptUploadDeleteThrowExceptionTest() {

        // ASSERT
        assertThrows(RecordNotFoundException.class, () -> receiptUploadService.getFileById(1L));
    }

}
