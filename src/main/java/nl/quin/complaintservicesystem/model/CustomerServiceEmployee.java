package nl.quin.complaintservicesystem.model;

import javax.persistence.*;

@Entity
@Table(name = "customers_service_employees")
public class CustomerServiceEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;

    @Column(name = "order_nr")
    String orderNr;

    @Column(name = "customerService_commentary")
    String customerServiceCommentary;

    // standard constructors

    // getters, and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderNr() { return orderNr; }

    public void setOrderNr(String orderNr) {
        this.orderNr = orderNr;
    }

    public String getCustomerServiceCommentary() { return customerServiceCommentary; }

    public void setCustomerServiceCommentary(String customerServiceCommentary) {
        this.customerServiceCommentary = customerServiceCommentary;
    }
}

