package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String username;

    @NotBlank(message = "FIRST NAME is mandatory")
    @Column
    String firstName;

    @NotBlank(message = "LAST NAME is mandatory")
    @Column
    String lastName;

    @NotBlank(message = "EMAIL is mandatory")
    @Column
    String email;

    @OneToMany(mappedBy = "customerDetails",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonBackReference("customerComplaintCustomerDetails")
    List<CustomerComplaint> customerComplaintList;

    @JsonIgnore
    @OneToOne(mappedBy = "customerDetails")
    User user;

    // CONSTRUCTORS

    public CustomerDetails() {
    }

    public CustomerDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerDetails(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    // GETTERS SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}