package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    private String username;
    private String email;

    @OneToMany(mappedBy = "customerDetails")
    @JsonBackReference
    private List<CustomerComplaint> customerComplaintList = new ArrayList<>();
    //private CustomerComplaint customerComplaint;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CustomerComplaint> getCustomerComplaintList() {
        return customerComplaintList;
    }

    public void setCustomerComplaintList(List<CustomerComplaint> customerComplaintList) {
        this.customerComplaintList = customerComplaintList;
    }
}