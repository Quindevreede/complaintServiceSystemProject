package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.ProductionComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductionComplaintDetailsRepository extends JpaRepository<ProductionComplaintDetails, Long> {
    Collection<ProductionComplaintDetails> findAllByName(String name);
}
