package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerReplyRepository extends JpaRepository<CustomerReply, Long> {

    Optional<CustomerReply> findById(Long id);

}