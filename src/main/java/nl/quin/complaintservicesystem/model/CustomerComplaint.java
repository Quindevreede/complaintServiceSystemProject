package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import nl.quin.complaintservicesystem.method1.Method1File;

import javax.persistence.*;

@Entity
@Table(name = "customer_complaint")
public class CustomerComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //Corresponds to user id : username
    @Column
    String username;

    @Column
    String orderNumber;

    @Column
    String customerCommentary;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_details_id", nullable = false)
    @JsonIgnore
    private CustomerDetails customerDetails;


@OneToOne(mappedBy = "customerComplaint", cascade = CascadeType.ALL)
private Upload upload;


  /*  @OneToOne
    Upload upload;
    //TODO MET =GETTERS SETTERS
   */

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

    public String getCustomerCommentary() {return customerCommentary;}

    public void setCustomerCommentary(String customerCommentary) {this.customerCommentary = customerCommentary;}

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

/*
    public Method1File getMethod1File() {
        return method1File;
    }

    public void setMethod1File(Method1File method1File) {
        this.method1File = method1File;
    }

 */
}
/* //TODO//TODO//TODO
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_details", nullable = false)
    //@JsonManagedReference DEZE GEEFT "status": 415, "error": "Unsupported Media Type",
    private CustomerDetails customerDetails;

    public CustomerDetails getCustomerDetails() {return customerDetails;}

    public void setCustomerDetails(CustomerDetails customerDetails) {this.customerDetails = customerDetails;}

---- //TODO//TODO//TODO

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }
 */