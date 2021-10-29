/*package nl.quin.complaintservicesystem.model;

         import com.fasterxml.jackson.annotation.JsonIgnore;
         import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

         import javax.persistence.*;
         import java.math.BigDecimal;
         import java.time.LocalDate;

@Entity
@Table(name = "customer_details_upload_download_results")
public class CustomerDetailsUploadDownloadResult {


    @EmbeddedId
    @JsonIgnore
    private CustomerDetailsUploadDownloadResultKey id;

    @ManyToOne
    @MapsId("customerDetailsId")
    @JoinColumn(name = "customer_details_id")
    @JsonIgnoreProperties("results")
    private CustomerDetails customerDetails;

    @ManyToOne
    @MapsId("uploadDownloadId")
    @JoinColumn(name = "upload_download_id")
    @JsonIgnoreProperties("results")
    private UploadDownload uploadDownload;

    @Column
    private LocalDate date;

    @Column
    private BigDecimal extra_costs;

    @ManyToOne
    @JoinColumn(name = "customer_details_id")
    private CustomerDetails customer_details;

    @ManyToOne
    @JoinColumn(name = "upload_download_id")
    private UploadDownload upload_download;

    public UploadDownload getUpload_download() {
        return upload_download;
    }

    public void setUpload_download(UploadDownload upload_download) {
        this.upload_download = upload_download;
    }

    public CustomerDetails getCustomer_details() {
        return customer_details;
    }

    public void setCustomer_details(CustomerDetails customer_details) {
        this.customer_details = customer_details;
    }

    // getters and setters
    public CustomerDetailsUploadDownloadResultKey getId() {
        return id;
    }
    public void setId(CustomerDetailsUploadDownloadResultKey id) {
        this.id = id;
    }
    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }
    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }
    public UploadDownload getUploadDownload() {
        return uploadDownload;
    }
    public void setUploadDownload(UploadDownload uploadDownload) {
        this.uploadDownload = uploadDownload;
    }
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {
        this.date = date.now();
    }
    public BigDecimal getExtra_costs() {
        return extra_costs;
    }
    public void setExtra_costs(BigDecimal extra_costs) {
        this.extra_costs = extra_costs;
    }
}
 */