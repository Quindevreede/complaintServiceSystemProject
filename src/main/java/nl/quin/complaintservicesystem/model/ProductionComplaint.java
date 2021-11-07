package nl.quin.complaintservicesystem.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "production_complaint")
public class ProductionComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String username;

    @Column
    String orderNumber;

    @Column
    String productionCommentary;

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

    public String getProductionCommentary() {
        return productionCommentary;
    }

    public void setProductionCommentary(String productionCommentary) {
        this.productionCommentary = productionCommentary;
    }
}
