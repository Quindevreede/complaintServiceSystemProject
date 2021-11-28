package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.Optional;

public interface CustomerComplaintRepository extends JpaRepository<CustomerComplaint, Long> {

    Collection<CustomerComplaint> findAllByOrderNumber(String orderNumber);
    Optional<CustomerComplaint> findByOrderNumber(String orderNumber);
    boolean existsByOrderNumber(String orderNumber);

}