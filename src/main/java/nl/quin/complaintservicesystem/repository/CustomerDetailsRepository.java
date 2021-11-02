package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}
