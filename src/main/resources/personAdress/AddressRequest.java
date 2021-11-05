package personAdress;

import javax.validation.constraints.NotBlank;

public class AddressRequest {

    @NotBlank(message = "Postal code is mandatory")
    private String postalCode;
    @NotBlank(message = "Streetname is mandatory")
    private String streetName;
    @NotBlank(message = "Housenumber is mandatory")
    private String houseNumber;
    private String addition;

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
}
