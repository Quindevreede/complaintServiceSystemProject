package nl.quin.complaintservicesystem.model;

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

    @Column
    boolean isRePrintAprroved;

    @ManyToOne
    CustomerDetails customerDetails;

 /*   @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_details_id", nullable = false)
    @JsonIgnore
    private CustomerDetails customerDetails;
  */

  /*
@OneToOne(mappedBy = "customerComplaint", cascade = CascadeType.ALL)
private Upload upload;
    //TODO MET =GETTERS SETTERS
   */

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

    public ProductionComplaint getProductionComplaint() {
        return productionComplaint;
    }

    public void setProductionComplaint(ProductionComplaint productionComplaint) {
        this.productionComplaint = productionComplaint;
    }

    public AssistComplaint getAssistComplaint() {
        return assistComplaint;
    }

    public void setAssistComplaint(AssistComplaint assistComplaint) {
        this.assistComplaint = assistComplaint;
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