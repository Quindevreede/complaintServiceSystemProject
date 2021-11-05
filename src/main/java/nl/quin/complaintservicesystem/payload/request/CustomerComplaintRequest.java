package nl.quin.complaintservicesystem.payload.request;

import javax.validation.constraints.NotBlank;

public class CustomerComplaintRequest {

    @NotBlank(message = "Order Number is mandatory")
    private String orderNumber;
    @NotBlank(message = "Customer Commentary is mandatory")
    private String customerCommentary;

    //GETTERS SETTERS
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
}