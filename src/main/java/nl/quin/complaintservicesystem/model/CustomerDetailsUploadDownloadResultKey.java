/*package nl.quin.complaintservicesystem.model;

        import javax.persistence.Column;
        import javax.persistence.Embeddable;
        import java.io.Serializable;
        import java.util.Objects;

@Embeddable
public class CustomerDetailsUploadDownloadResultKey implements Serializable {

    @Column(name = "customer_details_id")
    private Long customerDetailsId;

    @Column(name = "upload_download_id")
    private Long uploadDownloadId;

    // constructor(s)
    public CustomerDetailsUploadDownloadResultKey() {}
    public CustomerDetailsUploadDownloadResultKey(long customerDetailsId, long uploadDownloadId) {
        this.customerDetailsId = customerDetailsId;
        this.uploadDownloadId = uploadDownloadId;
    }

    // getters and setters
    public Long getCustomerDetailsId() {
        return customerDetailsId;
    }
    public void setCustomerDetailsId(Long customerDetailsId) {
        this.customerDetailsId = customerDetailsId;
    }
    public Long getUploadDownloadId() {
        return uploadDownloadId;
    }
    public void setUploadDownloadId(Long uploadDownloadId) {
        this.uploadDownloadId = uploadDownloadId;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetailsUploadDownloadResultKey that = (CustomerDetailsUploadDownloadResultKey) o;
        return customerDetailsId.equals(that.customerDetailsId) &&
                uploadDownloadId.equals(that.uploadDownloadId);
    }

    // hashcode
    @Override
    public int hashCode() {
        return Objects.hash(customerDetailsId, uploadDownloadId);
    }
}
 */