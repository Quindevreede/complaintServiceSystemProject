package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class CustomerComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String orderNumber;
    private String customerCommentary;


    @ManyToOne
    @JsonBackReference
    private CustomerDetails customerDetails;

    @OneToOne
    @JsonBackReference("customerComplaintUploadDownload")
    UploadDownload uploadDownload;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public UploadDownload getUploadDownload() {
        return uploadDownload;
    }

    public void setUploadDownload(UploadDownload uploadDownload) {
        this.uploadDownload = uploadDownload;
    }
}