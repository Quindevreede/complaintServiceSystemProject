package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.ProductionComplaint;
import nl.quin.complaintservicesystem.repository.ProductionComplaintRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProductionComplaintServiceTest {

    @Mock
    ProductionComplaint productionComplaint;

    @InjectMocks
    ProductionComplaintService productionComplaintService;

    @Mock
    ProductionComplaintRepository productionComplaintRepository;

    @Captor
    ArgumentCaptor<ProductionComplaint> productionComplaintCaptor;

    @Test
    void testGetProductionComplaintByIdThrowException() {
        when(productionComplaintRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> {
            productionComplaintService.getProductionComplaintById(1L);

        });
    }

    @Test
    public void testGetProductionComplaint() {
        productionComplaint = new ProductionComplaint();
        productionComplaint.setAssistedBy("Peter");
        productionComplaint.setId(1L);

        Mockito

                .when(productionComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(productionComplaint));

        String expected = "Peter";

        productionComplaintService.getProductionComplaintById(1L);
        assertEquals(expected, productionComplaint.getAssistedBy());
    }

    @Test
    public void createProductionComplaintTest() {
        productionComplaint = new ProductionComplaint();
        productionComplaint.setId(1L);
        productionComplaint.setAssistedBy("Peter");
        productionComplaint.setProductionDepartment("Posters and stickers");
        productionComplaint.setProductionCommentary("original image was very dark, fixed bij changing print settings, no extra costs" );

        productionComplaintRepository.save(productionComplaint);

        verify(productionComplaintRepository, times(1)).save(productionComplaintCaptor.capture());
        var productionComplaint1 = productionComplaintCaptor.getValue();

        assertThat(productionComplaint1.getAssistedBy()).isEqualTo("Peter");
        assertThat(productionComplaint1.getProductionDepartment()).isEqualTo("Posters and stickers");
        assertThat(productionComplaint1.getProductionCommentary()).isEqualTo("original image was very dark, fixed bij changing print settings, no extra costs" );
        assertThat(productionComplaint1.getId()).isEqualTo(1);
    }

    @Test
    public void updateProductionComplaintDeleteThrowExceptionTest() {
        assertThrows(UserNotFoundException.class, () -> productionComplaintService.getProductionComplaintById(1L));
    }

    @Test
    public void deleteProductionComplaintTest() {
        productionComplaint = new ProductionComplaint();
        productionComplaint.setId(1L);
        productionComplaint.setAssistedBy("Peter");

        productionComplaintRepository.delete(productionComplaint);

        Mockito

                .when(productionComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(productionComplaint));

        productionComplaintService.deleteProductionComplaint(1L);
        verify(productionComplaintRepository, times(1)).delete(productionComplaint);
    }

}



