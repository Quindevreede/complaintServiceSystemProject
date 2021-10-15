package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.Date;

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
    private Timestamp date;

    @Column
    private BigDecimal extra_costs;

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
    public Timestamp getDate() {return date;}
    public void setDate(Timestamp date) {
        this.date = date;
    }
    public BigDecimal getExtra_costs() {
        return extra_costs;
    }
    public void setExtra_costs(BigDecimal extra_costs) {
        this.extra_costs = extra_costs;
    }



}