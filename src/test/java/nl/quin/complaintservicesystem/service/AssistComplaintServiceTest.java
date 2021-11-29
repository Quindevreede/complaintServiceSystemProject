package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.AssistComplaint;
import nl.quin.complaintservicesystem.repository.AssistComplaintRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class AssistComplaintServiceTest {

    @Mock
    AssistComplaint assistComplaint;

    @InjectMocks
    AssistComplaintService assistComplaintService;

    @Mock
    AssistComplaintRepository assistComplaintRepository;

    @Captor
    ArgumentCaptor<AssistComplaint> assistComplaintCaptor;

    @Test
    void getAllAssistComplaintsTest() {

        // ARRANGE
        List<AssistComplaint> assistComplaints = new ArrayList();
        assistComplaints.add(new AssistComplaint(1L, "Peter", "FrontDesk", "Can Fix, but with extra costs", BigDecimal.valueOf(7.77), "www.huh1.com"));
        assistComplaints.add(new AssistComplaint(2L,"Paula", "PhoneAssist", "Can Fix, without extra costs", BigDecimal.valueOf(0.00),"www.huh2.com"));
        assistComplaints.add(new AssistComplaint(3L,"Patricia", "BackDesk", "Can Fix, but with extra costs", BigDecimal.valueOf(2.22), "www.huh3.com"));

        // ACT
        given(assistComplaintRepository.findAll()).willReturn(assistComplaints);

        // ASSERT
        List<AssistComplaint> expected = assistComplaintService.assistComplaintRepository.findAll();
        assertEquals(expected,assistComplaints);
    }

    @Test
    void getAssistComplaintByIdThrowExceptionTest() {

        // ACT
        when(assistComplaintRepository.findById(1L)).thenReturn(Optional.empty());

        // ASSERT
        assertThrows(UserNotFoundException.class, () -> {
            assistComplaintService.getAssistComplaintById(1L);

        });
    }

    @Test
    void getAssistComplaintIsNullErrorTest() {

        // ARRANGE
        String assistedBy = null;

        // ACT
        Mockito
                .when(assistComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(assistComplaint));

        // ASSERT
        assertNull(assistedBy, "assistedBy should not be found");
    }

    @Test
    public void getAssistComplaintTest() {

        // ARRANGE
        assistComplaint = new AssistComplaint();
        assistComplaint.setAssistedBy("Peter");
        assistComplaint.setId(1L);

        // ACT
        Mockito
                .when(assistComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(assistComplaint));

        // ASSERT
        String expected = "Peter";

        assistComplaintService.getAssistComplaintById(1L);
        assertEquals(expected, assistComplaint.getAssistedBy());
    }

    @Test
    public void createAssistComplaintTest() {

        // ACT
        assistComplaint = new AssistComplaint();
        assistComplaint.setId(1L);
        assistComplaint.setAssistedBy("Peter");
        assistComplaint.setAssistDepartment("Front Desk");
        assistComplaint.setAssistCommentary("some commentary");
        assistComplaint.setInvoiceLink("www.bla.com");
        assistComplaint.setExtraCosts(BigDecimal.valueOf(7.77));

        assistComplaintRepository.save(assistComplaint);

        // ARRANGE
        verify(assistComplaintRepository, times(1)).save(assistComplaintCaptor.capture());
        var assistComplaint1 = assistComplaintCaptor.getValue();

        // ASSERT
        assertThat(assistComplaint1.getAssistedBy()).isEqualTo("Peter");
        assertThat(assistComplaint1.getAssistDepartment()).isEqualTo("Front Desk");
        assertThat(assistComplaint1.getAssistCommentary()).isEqualTo("some commentary");
        assertThat(assistComplaint1.getInvoiceLink()).isEqualTo("www.bla.com");
        assertThat(assistComplaint1.getExtraCosts()).isEqualTo(BigDecimal.valueOf(7.77));
        assertThat(assistComplaint1.getId()).isEqualTo(1);
    }

    @Test
    public void createAssistComplaintTestByOnlyId() {

        // ARRANGE
        assistComplaint = new AssistComplaint();
        assistComplaint.setId(1L);
        given(assistComplaintRepository.findById(assistComplaint.getId())).willReturn(Optional.empty());
        given(assistComplaintRepository.save(assistComplaint)).willAnswer(invocation -> invocation.getArgument(0));

        // ACT
        long savedAssistComplaint = assistComplaintService.createAssistComplaint(assistComplaint);

        // ASSERT
        assertThat(savedAssistComplaint).isNotNull();

        verify(assistComplaintRepository).save(any(AssistComplaint.class));
    }

    @Test
    public void updateAssistComplaintDeleteThrowExceptionTest() {

        // ASSERT
        assertThrows(UserNotFoundException.class, () -> assistComplaintService.getAssistComplaintById(1L));
    }

    @Test
    public void deleteAssistComplaintTest() {

        // ARRANGE
        assistComplaint = new AssistComplaint();
        assistComplaint.setId(1L);
        assistComplaint.setAssistedBy("Peter");

        assistComplaintRepository.delete(assistComplaint);

        // ACT
        Mockito
                .when(assistComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(assistComplaint));

        assistComplaintService.deleteAssistComplaint(1L);

        // ASSERT
        verify(assistComplaintRepository, times(1)).delete(assistComplaint);
    }

}