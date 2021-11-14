package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.CustomerReply;
import nl.quin.complaintservicesystem.service.CustomerReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer_reply")
public class CustomerReplyController {

    @Autowired
    private CustomerReplyService customerReplyService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomerReply(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerReplyService.getCustomerReplyById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createAssistComplaint(@RequestBody CustomerReply customerReply) {
        long newId = customerReplyService.createCustomerReply(customerReply);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerReply(@PathVariable("id") long id, @RequestBody CustomerReply customerReply) {
        customerReplyService.updateCustomerReply(id, customerReply);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomerReply(@PathVariable("id") long id) {
        customerReplyService.deleteCustomerReply(id);
        return ResponseEntity.noContent().build();
    }

}