package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //Corresponds to user id : username
    @Column
    String username;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    String email;

    // CONSTRUCTORS

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

/* //TODO//TODO//TODO

    @OneToMany(mappedBy = "customerDetails",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonBackReference
    private List<CustomerComplaint> customerComplaint;

//TODO//TODO//TODO
---------------------

    public List<CustomerComplaint> getCustomerComplaint() {
        return customerComplaint;
    }

    public void setCustomerComplaint(List<CustomerComplaint> customerComplaint) {
        this.customerComplaint = customerComplaint;
    }

    public void addCustomerComplaint(CustomerComplaint customerComplaint) {
        this.customerComplaint.add(customerComplaint);
    }
 */

