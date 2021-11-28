package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "upload")
public class Upload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String fileName;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String orderNumberUpload;

    @Column
    private String location;

    @Column
    private String uploadedByUsername;

    @Column
    private Timestamp uploadedOnDate;

    @JsonIgnore
    @OneToOne(mappedBy = "upload")
    CustomerComplaint customerComplaint;

    // CONSTRUCTORS

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderNumberUpload() {
        return orderNumberUpload;
    }

    public void setOrderNumberUpload(String orderNumberUpload) {
        this.orderNumberUpload = orderNumberUpload;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUploadedByUsername() {
        return uploadedByUsername;
    }

    public void setUploadedByUsername(String uploadedByUsername) {
        this.uploadedByUsername = uploadedByUsername;
    }

    public Timestamp getUploadedOnDate() {
        return uploadedOnDate;
    }

    public void setUploadedOnDate(Timestamp uploadedOnDate) {
        this.uploadedOnDate = uploadedOnDate;
    }

    public CustomerComplaint getCustomerComplaint() {
        return customerComplaint;
    }

}