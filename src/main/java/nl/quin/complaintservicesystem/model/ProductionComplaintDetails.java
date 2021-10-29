package nl.quin.complaintservicesystem.model;

import javax.persistence.*;

@Entity
@Table(name = "production_complaint_details")
public class ProductionComplaintDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String orderNrCustomer;

    @Column
    String code;

    @Column
    String name;

    @Column
    String productionCommentary;

    @Column
    String rePrintApproved;

 /*   @OneToMany(mappedBy = "complaint",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
//    @JsonIgnore
    @JsonIgnoreProperties("complaint")
//    @JsonBackReference
//    @JsonManagedReference
    Set<CustomerComplaintResult> results;
*/

    // standard constructors

    // getters, and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   public String getOrderNrCustomer() {
        return orderNrCustomer;
    }

    public void setOrderNrCustomer(String orderNrCustomer) {
        this.orderNrCustomer = orderNrCustomer;
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

    public String getProductionCommentary() {
        return productionCommentary;
    }

    public void setProductionCommentary(String productionCommentary) {
        this.productionCommentary = productionCommentary;
    }

/*
    public Set<CustomerComplaintResult> getResults() {
        return results;
    }

    public void setResults(Set<CustomerComplaintResult> results) {
        this.results = results;
    }

 */
}
