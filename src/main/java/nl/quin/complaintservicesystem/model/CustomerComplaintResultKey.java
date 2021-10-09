package nl.quin.complaintservicesystem.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerComplaintResultKey implements Serializable {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "complaint_id")
    private Long courseId;

    // constructor(s)
    public CustomerComplaintResultKey() {}
    public CustomerComplaintResultKey(long customerId, long complaintId) {
        this.customerId = customerId;
        this.complaintId = complaintId;
    }

    // getters and setters
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getComplaintId() {
        return complaintId;
    }
    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerComplaintResultKey that = (CustomerComplaintResultKey) o;
        return customerId.equals(that.customerId) &&
                complaintId.equals(that.complaintId);
    }

    // hashcode
    @Override
    public int hashCode() {
        return Objects.hash(customerId, complaintId);
    }
}