package nl.quin.complaintservicesystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @NotBlank(message = "USERNAME is mandatory")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "PASSWORD is mandatory")
    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @OneToMany(
            targetEntity = nl.quin.complaintservicesystem.model.Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<nl.quin.complaintservicesystem.model.Authority> authorities = new HashSet<>();

    @OneToOne
    CustomerDetails customerDetails;

    // CONSTRUCTORS

    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // GETTERS SETTERS

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<nl.quin.complaintservicesystem.model.Authority> getAuthorities() {
        return authorities;
    }

    public void addAuthority(nl.quin.complaintservicesystem.model.Authority authority) { this.authorities.add(authority); }

    public void removeAuthority(nl.quin.complaintservicesystem.model.Authority authority) { this.authorities.remove(authority); }

    public CustomerDetails getCustomerDetails() { return customerDetails; }

    public void setCustomerDetails(CustomerDetails customerDetails) { this.customerDetails = customerDetails; }

}