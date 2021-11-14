package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerReply;
import nl.quin.complaintservicesystem.repository.CustomerReplyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class CustomerReplyService {

    @Autowired
    CustomerReplyRepository customerReplyRepository;

    @Autowired
    AssistComplaintService assistComplaintService;

    public CustomerReply getCustomerReplyById(long id) {
        if (!customerReplyRepository.existsById(id)) { throw new UserNotFoundException(); }
        return customerReplyRepository.findById(id).orElse(null);
    }

    public long createCustomerReply (CustomerReply customerReply) {
        customerReply.setTimestamp((Timestamp.valueOf(LocalDateTime.now())));
        CustomerReply storedCustomerReply = customerReplyRepository.save(customerReply);
        return storedCustomerReply.getId();
    }

    public void updateCustomerReply(long id, CustomerReply customerReply) {
        if (!customerReplyRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerReply storedCustomerReply = customerReplyRepository.findById(id).orElse(null);
        storedCustomerReply.setCustomerCommentary(customerReply.getCustomerCommentary());
        storedCustomerReply.setReprintOrRefund(customerReply.getReprintOrRefund());
        customerReplyRepository.save(customerReply);
    }

    public void deleteCustomerReply(long id) {
        if (!customerReplyRepository.existsById(id)) { throw new UserNotFoundException(); }
        customerReplyRepository.deleteById(id);
    }

}
