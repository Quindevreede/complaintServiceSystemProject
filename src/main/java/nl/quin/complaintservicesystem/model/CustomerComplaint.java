package nl.quin.complaintservicesystem.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_complaint")
public class CustomerComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String username;

    @Column
    String orderNumber;

    @Column
    String customerCommentary;

    @Column
    String isRePrintApproved;

    @ManyToOne
    CustomerDetails customerDetails;

    @OneToOne
    Upload upload;

    @OneToOne
    ProductionComplaint productionComplaint;

    @OneToOne
    AssistComplaint assistComplaint;

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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerCommentary() {
        return customerCommentary;
    }

    public void setCustomerCommentary(String customerCommentary) {
        this.customerCommentary = customerCommentary;
    }

    public String getIsRePrintApproved() { return isRePrintApproved; }

    public void setIsRePrintApproved(String isRePrintAprroved) { this.isRePrintApproved = isRePrintAprroved; }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public Upload getUpload() {
        return upload;
    }

    public void setUpload(Upload upload) {
        this.upload = upload;
    }

    public ProductionComplaint getProductionComplaint() {
        return productionComplaint;
    }

    public void setProductionComplaint(ProductionComplaint productionComplaint) { this.productionComplaint = productionComplaint; }

    public AssistComplaint getAssistComplaint() {
        return assistComplaint;
    }

    public void setAssistComplaint(AssistComplaint assistComplaint) {
        this.assistComplaint = assistComplaint;
    }

}