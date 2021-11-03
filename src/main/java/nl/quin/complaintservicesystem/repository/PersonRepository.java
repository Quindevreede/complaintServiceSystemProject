package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}