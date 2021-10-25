package nl.quin.complaintservicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String code;

    @Column(name = "file_name")
    String name;

    @Column
    String commentary;

    @Column(name = "or_customer")
    String orderNrCustomer;

    @OneToMany(mappedBy = "complaint")
//    @JsonIgnore
    @JsonIgnoreProperties("complaint")
//    @JsonBackReference
//    @JsonManagedReference
    Set<CustomerComplaintResult> results;

    // standard constructors

    // getters, and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCommentary() {
        return commentary;
    }
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
    public String getOrderNrCustomer() { return orderNrCustomer; }

    public void setOrderNrCustomer(String orderNrCustomer) {
        this.orderNrCustomer = orderNrCustomer;
    }

    public Set<CustomerComplaintResult> getResults() {
        return results;
    }

    public void setResults(Set<CustomerComplaintResult> results) {
        this.results = results;
    }
}
/*
package nl.quin.complaintservicesystem.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "order_number_customer_log")
    String orderNumberCustomerLog;

    @Column(name = "receipt_valid")
    String receiptValid;

    @Column(name = "file_name")
    String name;

    @Column(name = "re_print")
    String rePrint;

    @Column(name = "extra_costs_estimate")
    String ExtraCostsEstimate;

    @Column(name = "production_commentary")
    String productionCommentary;

    @OneToMany(mappedBy = "complaint")
//    @JsonIgnore
    @JsonIgnoreProperties("complaint")
//    @JsonBackReference
//    @JsonManagedReference
    Set<CustomerComplaintResult> results;

    // standard constructors

    // getters, and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumberCustomerLog() {
        return orderNumberCustomerLog;
    }

    public void setOrderNumberCustomerLog(String orderNumberCustomerLog) {
        this.orderNumberCustomerLog = orderNumberCustomerLog;
    }

    public String getReceiptValid() {
        return receiptValid;
    }

    public void setReceiptValid(String receiptValid) {
        this.receiptValid = receiptValid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRePrint() {
        return rePrint;
    }

    public void setRePrint(String rePrint) {
        this.rePrint = rePrint;
    }

    public String getExtraCostsEstimate() {
        return ExtraCostsEstimate;
    }

    public void setExtraCostsEstimate(String extraCostsEstimate) {
        ExtraCostsEstimate = extraCostsEstimate;
    }

    public String getProductionCommentary() {
        return productionCommentary;
    }

    public void setProductionCommentary(String productionCommentary) {
        this.productionCommentary = productionCommentary;
    }

    public Set<CustomerComplaintResult> getResults() {
        return results;
    }

    public void setResults(Set<CustomerComplaintResult> results) {
        this.results = results;
    }
}

 */