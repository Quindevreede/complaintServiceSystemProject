package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.ProductionEmployee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductionEmployeeRepository extends JpaRepository<ProductionEmployee, Long> {
    Collection<ProductionEmployee> findAllByLastName(String last_name);
}