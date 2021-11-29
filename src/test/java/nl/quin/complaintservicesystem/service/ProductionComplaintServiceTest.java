package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.ProductionComplaint;
import nl.quin.complaintservicesystem.repository.ProductionComplaintRepository;
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
    void getAllProductionComplaintsTest() {

        // ARRANGE
        List<ProductionComplaint> productionComplaints = new ArrayList();
        productionComplaints.add(new ProductionComplaint(1L, "Peter", "FrontDesk", "Can Fix, but with extra costs"));
        productionComplaints.add(new ProductionComplaint(2L,"Paula", "PhoneAssist", "Can Fix, without extra costs"));
        productionComplaints.add(new ProductionComplaint(3L,"Patricia", "BackDesk", "Can Fix, but with extra costs"));

        // ACT
        given(productionComplaintRepository.findAll()).willReturn(productionComplaints);

        // ASSERT
        List<ProductionComplaint> expected = productionComplaintService.productionComplaintRepository.findAll();
        assertEquals(expected,productionComplaints);
    }

    @Test
    void getProductionComplaintByIdThrowExceptionTest() {

        // ACT
        when(productionComplaintRepository.findById(1L)).thenReturn(Optional.empty());

        // ASSERT
        assertThrows(UserNotFoundException.class, () -> {
            productionComplaintService.getProductionComplaintById(1L);

        });
    }

    @Test
    void getProductionComplaintIsNullErrorTest() {

        // ARRANGE
        String assistedBy = null;

        // ACT
        Mockito
                .when(productionComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(productionComplaint));

        // ASSERT
        assertNull(assistedBy, "assistedBy should not be found");
    }

    @Test
    public void getProductionComplaintTest() {

        // ARRANGE
        productionComplaint = new ProductionComplaint();
        productionComplaint.setAssistedBy("Peter");
        productionComplaint.setId(1L);

        // ACT
        Mockito
                .when(productionComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(productionComplaint));

        // ASSERT
        String expected = "Peter";

        productionComplaintService.getProductionComplaintById(1L);
        assertEquals(expected, productionComplaint.getAssistedBy());
    }

    @Test
    public void createProductionComplaintTest() {

        // ARRANGE
        productionComplaint = new ProductionComplaint();
        productionComplaint.setId(1L);
        productionComplaint.setAssistedBy("Peter");
        productionComplaint.setProductionDepartment("Posters and stickers");
        productionComplaint.setProductionCommentary("original image was very dark, fixed bij changing print settings, no extra costs" );

        productionComplaintRepository.save(productionComplaint);

        // ACT
        verify(productionComplaintRepository, times(1)).save(productionComplaintCaptor.capture());
        var productionComplaint1 = productionComplaintCaptor.getValue();

        // ASSERT
        assertThat(productionComplaint1.getAssistedBy()).isEqualTo("Peter");
        assertThat(productionComplaint1.getProductionDepartment()).isEqualTo("Posters and stickers");
        assertThat(productionComplaint1.getProductionCommentary()).isEqualTo("original image was very dark, fixed bij changing print settings, no extra costs" );
        assertThat(productionComplaint1.getId()).isEqualTo(1);
    }

    @Test
    public void createProductionComplaintTestByOnlyId() {

        // ARRANGE
        productionComplaint = new ProductionComplaint();
        productionComplaint.setId(1L);
        given(productionComplaintRepository.findById(productionComplaint.getId())).willReturn(Optional.empty());
        given(productionComplaintRepository.save(productionComplaint)).willAnswer(invocation -> invocation.getArgument(0));

        // ACT
        long savedProductionComplaint = productionComplaintService.createProductionComplaint(productionComplaint);

        // ASSERT
        assertThat(savedProductionComplaint).isNotNull();

        verify(productionComplaintRepository).save(any(ProductionComplaint.class));
    }

    @Test
    public void updateProductionComplaintDeleteThrowExceptionTest() {

        // ASSERT
        assertThrows(UserNotFoundException.class, () -> productionComplaintService.getProductionComplaintById(1L));
    }

    @Test
    public void deleteProductionComplaintTest() {

        // ARRANGE
        productionComplaint = new ProductionComplaint();
        productionComplaint.setId(1L);
        productionComplaint.setAssistedBy("Peter");

        productionComplaintRepository.delete(productionComplaint);

        // ACT
        Mockito
                .when(productionComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(productionComplaint));

        // ASSERT
        productionComplaintService.deleteProductionComplaint(1L);
        verify(productionComplaintRepository, times(1)).delete(productionComplaint);
    }

}



