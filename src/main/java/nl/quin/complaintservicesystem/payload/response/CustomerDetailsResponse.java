package nl.quin.complaintservicesystem.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDetailsResponse {


    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private String postalCode;
    private String streetName;
    private String houseNumber;
    private String title;
    private String description;
    private String addition;

    // CONSTRUCTORS

    public CustomerDetailsResponse() {
    }

    public CustomerDetailsResponse(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    // GETTERS SETTERS

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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
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

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public void setCustomerComplaint(String postalCode, String streetName, String houseNumber) {
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public void setUploadDownload(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
