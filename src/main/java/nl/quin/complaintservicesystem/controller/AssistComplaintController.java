package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.AssistComplaint;
import nl.quin.complaintservicesystem.service.AssistComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping(value = "/assist_complaint")
public class AssistComplaintController {

    @Autowired
    private AssistComplaintService assistComplaintService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getAssistComplaint(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(assistComplaintService.getAssistComplaintById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createAssistComplaint(@RequestBody AssistComplaint assistComplaint) {
        long newId = assistComplaintService.createAssistComplaint(assistComplaint);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateAssistComplaint(@PathVariable("id") long id, @RequestBody AssistComplaint assistComplaint) {
        assistComplaintService.updateAssistComplaint(id, assistComplaint);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteAssistComplaint(@PathVariable("id") long id) {
        assistComplaintService.deleteAssistComplaint(id);
        return ResponseEntity.noContent().build();
    }

}