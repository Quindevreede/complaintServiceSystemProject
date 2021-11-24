package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.AssistComplaint;
import nl.quin.complaintservicesystem.repository.AssistComplaintRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void testGetAssistComplaintByIdThrowException() {
        when(assistComplaintRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> {
            assistComplaintService.getAssistComplaintById(1L);

        });
    }

    @Test
    public void testGetAssistComplaint() {
        assistComplaint = new AssistComplaint();
        assistComplaint.setAssistedBy("Peter");
        assistComplaint.setId(1L);

        Mockito

                .when(assistComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(assistComplaint));

        String expected = "Peter";

        assistComplaintService.getAssistComplaintById(1L);
        assertEquals(expected, assistComplaint.getAssistedBy());
    }

    @Test
    public void createAssistComplaintTest() {
        assistComplaint = new AssistComplaint();
        assistComplaint.setId(1L);
        assistComplaint.setAssistedBy("Peter");
        assistComplaint.setAssistDepartment("Front Desk");
        assistComplaint.setAssistCommentary("some commentary");
        assistComplaint.setInvoiceLink("www.bla.com");
        assistComplaint.setExtraCosts(BigDecimal.valueOf(7.77));

        assistComplaintRepository.save(assistComplaint);

        verify(assistComplaintRepository, times(1)).save(assistComplaintCaptor.capture());
        var assistComplaint1 = assistComplaintCaptor.getValue();

        assertThat(assistComplaint1.getAssistedBy()).isEqualTo("Peter");
        assertThat(assistComplaint1.getAssistDepartment()).isEqualTo("Front Desk");
        assertThat(assistComplaint1.getAssistCommentary()).isEqualTo("some commentary");
        assertThat(assistComplaint1.getInvoiceLink()).isEqualTo("www.bla.com");
        assertThat(assistComplaint1.getExtraCosts()).isEqualTo(BigDecimal.valueOf(7.77));
        assertThat(assistComplaint1.getId()).isEqualTo(1);
    }

    @Test
    public void updateAssistComplaintDeleteThrowExceptionTest() {
        assertThrows(UserNotFoundException.class, () -> assistComplaintService.getAssistComplaintById(1L));
    }

    @Test
    public void deleteAssistComplaintTest() {
        assistComplaint = new AssistComplaint();
        assistComplaint.setId(1L);
        assistComplaint.setAssistedBy("Peter");

        assistComplaintRepository.delete(assistComplaint);

        Mockito

                .when(assistComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(assistComplaint));

        assistComplaintService.deleteAssistComplaint(1L);
        verify(assistComplaintRepository, times(1)).delete(assistComplaint);
    }

}