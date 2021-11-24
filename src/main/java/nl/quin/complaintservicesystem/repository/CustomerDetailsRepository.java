package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerDetails;
import org.hibernate.tool.hbm2ddl.ColumnMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
    boolean existsById(Long id);
    Collection<CustomerDetails> findAllByLastName(String last_name);
    boolean existsByEmail(String email);
    Optional<CustomerDetails> findByUsername(String username);
}