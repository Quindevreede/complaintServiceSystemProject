package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "customer_reply")
public class CustomerReply {

    @Id
    Long id;

    @Column
    String reprintOrRefund;

    @Column
    String customerCommentary;

    @Column
    private Timestamp Timestamp;

    @JsonIgnore
    @OneToOne(mappedBy = "customerReply")
    CustomerComplaint customerComplaint;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReprintOrRefund() { return reprintOrRefund; }

    public void setReprintOrRefund(String reprintOrRefund) { this.reprintOrRefund = reprintOrRefund; }

    public String getCustomerCommentary() { return customerCommentary; }

    public void setCustomerCommentary(String customerCommentary) { this.customerCommentary = customerCommentary; }

    public Timestamp getTimestamp() { return Timestamp; }

    public void setTimestamp(Timestamp Timestamp) { this.Timestamp = Timestamp; }

    public CustomerComplaint getCustomerComplaint() { return customerComplaint; }

    public void setCustomerComplaint(CustomerComplaint customerComplaint) { this.customerComplaint = customerComplaint; }

}

