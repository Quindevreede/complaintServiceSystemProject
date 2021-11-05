package personAdress;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String postalCode;
    private String streetName;
    private String houseNumber;
    private String addition;


    @OneToOne
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
