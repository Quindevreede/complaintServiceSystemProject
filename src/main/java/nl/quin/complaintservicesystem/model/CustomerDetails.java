package nl.quin.complaintservicesystem.model;

import javax.persistence.*;

@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    private String username;
    private String email;
    private String password;


    @OneToOne(mappedBy = "customerDetails")
    private CustomerComplaint customerComplaint;

    @OneToOne(mappedBy = "customerDetails")
    private UploadDownload uploadDownload;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomerComplaint getCustomerComplaint() {
        return customerComplaint;
    }

    public void setCustomerComplaint(CustomerComplaint customerComplaint) {
        this.customerComplaint = customerComplaint;
    }

    public UploadDownload getUploadDownload() {
        return uploadDownload;
    }

    public void setUploadDownload(UploadDownload uploadDownload) {
        this.uploadDownload = uploadDownload;
    }

}
