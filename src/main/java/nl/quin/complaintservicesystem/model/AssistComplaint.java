package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "assist_complaint")
public class AssistComplaint {

    @Id
    Long id;

    @Column
    String orderNumber;

    @Column
    String assistedBy;

    @Column
    String assistDepartment;

    @Column
    String assistCommentary;

    @Column
    BigDecimal extraCosts;

    @JsonIgnore
    @OneToOne(mappedBy = "assistComplaint")
    CustomerComplaint customerComplaint;

    // CONSTRUCTORS

    // GETTERS SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAssistedBy() { return assistedBy; }

    public void setAssistedBy(String assistedBy) { this.assistedBy = assistedBy; }

    public String getAssistDepartment() { return assistDepartment; }

    public void setAssistDepartment(String assistDepartment) { this.assistDepartment = assistDepartment; }

    public String getAssistCommentary() { return assistCommentary; }

    public void setAssistCommentary(String assistCommentary) { this.assistCommentary = assistCommentary; }

    public BigDecimal getExtraCosts() { return extraCosts; }

    public void setExtraCosts(BigDecimal extraCosts) { this.extraCosts = extraCosts; }

    public CustomerComplaint getCustomerComplaint() { return customerComplaint; }

    public void setCustomerComplaint(CustomerComplaint customerComplaint) { this.customerComplaint = customerComplaint; }

}
