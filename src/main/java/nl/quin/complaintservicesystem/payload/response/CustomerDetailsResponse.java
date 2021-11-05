package nl.quin.complaintservicesystem.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import nl.quin.complaintservicesystem.model.CustomerComplaint;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDetailsResponse {

    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private String orderNumber;
    private String customerCommentary;


    private List<CustomerComplaint> customerComplaintList= new ArrayList<>();

    // CONSTRUCTORS

    public CustomerDetailsResponse() {
    }

    public CustomerDetailsResponse(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public void addCustomerComplaint(CustomerComplaint customerComplaint){
        customerComplaintList.add(customerComplaint);
    }


    //Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public List<CustomerComplaint> getCustomerComplaintList() {
        return customerComplaintList;
    }

    public void setCustomerComplaintList(List<CustomerComplaint> customerComplaintList) {
        this.customerComplaintList = customerComplaintList;
    }
}