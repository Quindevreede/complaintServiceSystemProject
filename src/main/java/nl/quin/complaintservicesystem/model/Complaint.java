package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.quin.complaintservicesystem.model.Customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Complaint /*extends Customer*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String code;

    @Column
    String name;

    @Column
    String commentary;

    @Column
    String customerNr;

    @OneToMany(mappedBy = "complaint")
//    @JsonIgnore
    @JsonIgnoreProperties("complaint")
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCommentary() {
        return commentary;
    }
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
   // public String getCustomerNr() { return customerNr; }

    public Set<CustomerComplaintResult> getResults() {
        return results;
    }

    public void setResults(Set<CustomerComplaintResult> results) {
        this.results = results;
    }
}