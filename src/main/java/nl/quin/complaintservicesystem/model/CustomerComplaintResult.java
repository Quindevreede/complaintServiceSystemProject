package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "customer_complaint_results")
public class CustomerComplaintResult {

    @EmbeddedId
    @JsonIgnore
    private CustomerComplaintResultKey id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("results")
    private Customer customer;

    @ManyToOne
    @MapsId("complaintId")
    @JoinColumn(name = "complaint_id")
    @JsonIgnoreProperties("results")
    private Complaint complaint;

    @Column
    private LocalDate date;

    @Column
    private BigDecimal extraCosts;

    // getters and setters
    public CustomerComplaintResultKey getId() {
        return id;
    }
    public void setId(CustomerComplaintResultKey id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Complaint getComplaint() {
        return complaint;
    }
    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
   /* public BigDecimal getExtraCosts() {
        return extraCosts;
    }
    public void setExtraCosts(BigDecimal extraCosts) {
        this.extraCosts = extraCosts;
    }

    */

}