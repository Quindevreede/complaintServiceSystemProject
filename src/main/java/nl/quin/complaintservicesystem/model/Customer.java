package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "customer_nr")
    String customerNr;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
//    @JsonBackReference
//    @JsonManagedReference
    Set<CustomerComplaintResult> results;

    // standard constructors

    // getters, and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCustomerNr() {
        return customerNr;
    }

    public void setCustomerNr(String customerNr) {
        this.customerNr = customerNr;
    }

    public Set<CustomerComplaintResult> getResults() {
        return results;
    }

    public void setResults(Set<CustomerComplaintResult> results) {
        this.results = results;
    }

}
