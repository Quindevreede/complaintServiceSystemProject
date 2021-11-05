/*package nl.quin.complaintservicesystem.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponse {


    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private String postalCode;
    private String streetName;
    private String houseNumber;
    private String addition;

    public PersonResponse() {
    }

    public PersonResponse(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

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
        return postalCode;
    }

    public void setOrderNumber(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCustomerCommentary() {
        return streetName;
    }

    public void setCustomerCommentary(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLatestComplaintAddition() {
        return addition;
    }

    public void setLatestComplaintAddition(String addition) {
        this.addition = addition;
    }

    public void setAddress(String postalCode, String streetName, String houseNumber) {
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }
}

 */