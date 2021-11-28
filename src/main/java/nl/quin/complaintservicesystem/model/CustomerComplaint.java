package nl.quin.complaintservicesystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customer_complaint")
public class CustomerComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String username;

    @NotBlank(message = "ORDERNUMBER is mandatory")
    @Column
    String orderNumber;

    @Column
    String customerCommentary;

    @ManyToOne
    CustomerDetails customerDetails;

    @OneToOne
    Upload upload;

    @OneToOne
    ReceiptUpload receiptUpload;

    @OneToOne
    ProductionComplaint productionComplaint;

    @OneToOne
    AssistComplaint assistComplaint;

    @OneToOne
    CustomerReply customerReply;

    // CONSTRUCTORS

    public CustomerComplaint() {
    }

    public CustomerComplaint(Long id, String orderNumber, String customerCommentary) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customerCommentary = customerCommentary;
    }

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

    public ReceiptUpload getReceiptUpload() { return receiptUpload; }

    public void setReceiptUpload(ReceiptUpload receiptUpload) { this.receiptUpload = receiptUpload; }

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

    public CustomerReply getCustomerReply() { return customerReply; }

    public void setCustomerReply(CustomerReply customerReply) { this.customerReply = customerReply; }

}