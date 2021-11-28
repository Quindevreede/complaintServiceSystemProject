package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.ProductionComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductionComplaintRepository extends JpaRepository<ProductionComplaint, Long> {

    Optional<ProductionComplaint> findById(Long id);

}