package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;
import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.Authority;
import nl.quin.complaintservicesystem.model.User;
import nl.quin.complaintservicesystem.payload.request.UserPostRequest;
import nl.quin.complaintservicesystem.repository.CustomerDetailsRepository;
import nl.quin.complaintservicesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

//    @Autowired
//    private AuthorityRepository authorityRepository;

    //op public gezet, also called in customerservice
    public String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetails) authentication.getPrincipal()).getUsername();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }


    public String createUser(UserPostRequest userPostRequest) {
        String encryptedPassword = passwordEncoder.encode(userPostRequest.getPassword());
        if(userRepository.existsByUsername(userPostRequest.getUsername())) {
            throw new RuntimeException("The username is already in use.");        }

        User user = new User();
        user.setUsername(userPostRequest.getUsername());
        user.setPassword(encryptedPassword);
        user.setEnabled(true);
        user.getAuthorities().add(new Authority(user.getUsername(),"ROLE_USER"));
        User newUser = userRepository.save(user);
        return newUser.getUsername();
    } // Wat je doet hier in Create User kun je alleen maar customers creeeren

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, User newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        if(userRepository.existsByUsername(newUser.getUsername())) {
            throw new RuntimeException("The username is already in use.");        }
        User user = userRepository.findById(username).get();
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));

        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UserNotFoundException(username);
        User user = userRepository.findById(username).get();
        return user.getAuthorities();
    }

    public void addAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UserNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UserNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }


    public void assignCustomerDetailsToUser(Long customerDetailsId, String username) {

        var optionalUser = userRepository.findById(username);

        var optionalCustomerDetails = customerDetailsRepository.findById(customerDetailsId);

        if (optionalCustomerDetails.isPresent() && optionalUser.isPresent()) {

            var user = optionalUser.get();

            var customerDetails = optionalCustomerDetails.get();

            user.setCustomerDetails(customerDetails);

            userRepository.save(user);

        }

    }
}