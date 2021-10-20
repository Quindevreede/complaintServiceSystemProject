package nl.quin.complaintservicesystem.service;

import lombok.RequiredArgsConstructor;
import nl.quin.complaintservicesystem.model.ERole;
import nl.quin.complaintservicesystem.model.Role;
import nl.quin.complaintservicesystem.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor // Lombok to create the Required Args Constructor
@Service // Instruct Spring Boot that this is the Service layer
public class RoleService {

    // Import Methods from other Class
    private final RoleRepository roleRepository; // Class from which methods are being imported

    // Get role by name
    public Optional<Role> getRoleByName(ERole name) { // Generate function
        return roleRepository.getRoleByName(name); // Call JPA function via the Repository
    }

}
