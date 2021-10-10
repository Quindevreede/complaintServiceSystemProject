package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.Complaint;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    Collection<Complaint> findAllByName(String name);
}
