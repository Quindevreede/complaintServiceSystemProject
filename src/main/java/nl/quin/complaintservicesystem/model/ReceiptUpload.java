package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nl.quin.complaintservicesystem.model.CustomerComplaint;

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

    @Column
    private String uploadedByEmployee;

    @JsonIgnore
    @OneToOne(mappedBy = "receiptUpload")
    CustomerComplaint customerComplaint;

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

    public String getUploadedByEmployee() {
        return uploadedByEmployee;
    }

    public void setUploadedByEmployee(String uploadedByEmployee) {
        this.uploadedByEmployee = uploadedByEmployee;
    }

    public CustomerComplaint getCustomerComplaint() { return customerComplaint; }

    public void setCustomerComplaint(CustomerComplaint customerComplaint) { this.customerComplaint = customerComplaint; }

}