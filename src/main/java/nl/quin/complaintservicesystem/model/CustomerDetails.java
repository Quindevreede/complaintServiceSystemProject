package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "customerDetails",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
//    @JsonBackReference
    private List<CustomerComplaint> customerComplaints;


   @JsonIgnore
   @OneToOne(mappedBy = "customerDetails")
   User user;

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

    public List<CustomerComplaint> getCustomerComplaints() {
        return customerComplaints;
    }

    public void setCustomerComplaints(List<CustomerComplaint> customerComplaints) {
        this.customerComplaints = customerComplaints;
    }


    // methoden
    void addCustomerComplaint(CustomerComplaint customerComplaint) {
        this.customerComplaints.add(customerComplaint);
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

