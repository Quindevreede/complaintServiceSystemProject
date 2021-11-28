package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "receiptUpload")
public class ReceiptUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String fileName;

    @Column
    private String ordernumber;

    @Column
    private String location;

    @Column
    private Timestamp uploadedTimestamp;

    @JsonIgnore
    @OneToOne(mappedBy = "receiptUpload")
    CustomerComplaint customerComplaint;

    // CONSTRUCTORS

    public ReceiptUpload() {
    }

    // GETTERS SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOrdernumber() { return ordernumber; }

    public void setOrdernumber(String ordernumber) { this.ordernumber = ordernumber; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getUploadedTimestamp() {
        return uploadedTimestamp;
    }

    public void setUploadedTimestamp(Timestamp uploadedTimestamp) {
        this.uploadedTimestamp = uploadedTimestamp;
    }

    public CustomerComplaint getCustomerComplaint() { return customerComplaint; }

    public void setCustomerComplaint(CustomerComplaint customerComplaint) { this.customerComplaint = customerComplaint; }

}
