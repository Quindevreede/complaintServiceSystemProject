package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "production_complaint")
public class ProductionComplaint {

    @Id
    Long id;

    @Column
    String orderNumber;

    @Column
    String assistedBy;

    @Column
    String productionDepartment;

    @Column
    String productionCommentary;

    @JsonIgnore
    @OneToOne(mappedBy = "productionComplaint")
    CustomerComplaint customerComplaint;

    // CONSTRUCTORS

    // GETTERS SETTERS

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getOrderNumber() { return orderNumber; }

    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber;}

    public String getAssistedBy() { return assistedBy; }

    public void setAssistedBy(String assistedBy) { this.assistedBy = assistedBy; }

    public String getProductionDepartment() { return productionDepartment; }

    public void setProductionDepartment(String productionDepartment) { this.productionDepartment = productionDepartment; }

    public String getProductionCommentary() { return productionCommentary; }

    public void setProductionCommentary(String productionCommentary) { this.productionCommentary = productionCommentary; }

    public CustomerComplaint getCustomerComplaint() { return customerComplaint; }

    public void setCustomerComplaint(CustomerComplaint customerComplaint) { this.customerComplaint = customerComplaint; }

}