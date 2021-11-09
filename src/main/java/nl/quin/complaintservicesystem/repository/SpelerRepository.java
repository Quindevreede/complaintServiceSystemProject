package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.Speler;
import nl.quin.complaintservicesystem.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface SpelerRepository extends CrudRepository<Speler, Long> {
}
