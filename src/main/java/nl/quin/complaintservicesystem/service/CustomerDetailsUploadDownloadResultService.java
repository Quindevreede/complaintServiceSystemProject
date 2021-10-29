/*package nl.quin.complaintservicesystem.service;

        import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;

        import nl.quin.complaintservicesystem.model.CustomerDetails;
        import nl.quin.complaintservicesystem.model.CustomerDetailsUploadDownloadResult;
        import nl.quin.complaintservicesystem.model.CustomerDetailsUploadDownloadResultKey;
        import nl.quin.complaintservicesystem.model.UploadDownload;
        import nl.quin.complaintservicesystem.repository.CustomerDetailsRepository;
        import nl.quin.complaintservicesystem.repository.CustomerDetailsUploadDownloadResultRepository;
        import nl.quin.complaintservicesystem.repository.UploadDownloadRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Collection;
        import java.util.Map;

@Service
public class CustomerDetailsUploadDownloadResultService {

    @Autowired
    UploadDownloadRepository uploadDownloadRepository;

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    CustomerDetailsUploadDownloadResultRepository customerDetailsUploadDownloadResultRepository;

    public Collection<CustomerDetailsUploadDownloadResult> getAllResults() {
        Collection<CustomerDetailsUploadDownloadResult> results = customerDetailsUploadDownloadResultRepository.findAll();
        return results;
    }

    public Collection<CustomerDetailsUploadDownloadResult> getResultsByCustomerId(long customerId) {
        return customerDetailsUploadDownloadResultRepository.findAllByCustomerDetailsId(customerId);
    }

    public Collection<CustomerDetailsUploadDownloadResult> getResultsByComplaintId(long complaintId) {
        return customerDetailsUploadDownloadResultRepository.findAllByUploadDownloadId(complaintId);
    }

    public CustomerDetailsUploadDownloadResult getResultById(long customerDetailsId, long uploadDownloadId) {
        return CustomerDetailsUploadDownloadResultRepository.findById(new CustomerDetailsUploadDownloadResultKey(customerDetailsId, new UploadDownload(""))).orElse(null);
    }

    public CustomerDetailsUploadDownloadResultKey addResult(long customerDetailsId, long uploadDownloadId, CustomerDetailsUploadDownloadResult result) {
        if (!customerDetailsRepository.existsById(customerDetailsId)) { throw new RecordNotFoundException(); }
        CustomerDetails customerDetails = customerDetailsRepository.findById(customerDetailsId).orElse(null);
        if (!uploadDownloadRepository.existsById(uploadDownloadId)) { throw new RecordNotFoundException(); }
        UploadDownload uploadDownload = uploadDownloadRepository.findById(uploadDownloadId).orElse(null);
        result.setCustomerDetails(customerDetails);
        result.setUploadDownload(uploadDownload);
        CustomerDetailsUploadDownloadResultKey id = new CustomerDetailsUploadDownloadResultKey(customerDetailsId, uploadDownloadId);
        result.setId(id);
        customerDetailsUploadDownloadRepository.save(result);
        return id;
    }

    public void updateResult(long customerDetailsId, long uploadDownloadtId, CustomerDetailsUploadDownloadResult result) {
        CustomerDetailsUploadDownloadResultKey id = new CustomerDetailsUploadDownloadResultKey(customerDetailsId, uploadDownloadtId);
        if (!customerDetailsUploadDownloadResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        CustomerDetailsUploadDownloadResult existingResult = customerDetailsUploadDownloadResultRepository.findById(id).orElse(null);
        existingResult.setDate(result.getDate());
        existingResult.setExtra_costs(result.getExtra_costs());
        customerDetailsUploadDownloadResultRepository.save(existingResult);
    }

    public void partialUpdateResult(long customerDetailsId, long uploadDownloadId, CustomerDetailsUploadDownloadResult result) {
        CustomerDetailsUploadDownloadResultKey id = new CustomerDetailsUploadDownloadResultKey(customerDetailsId, uploadDownloadId);
        if (!customerDetailsUploadDownloadResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        CustomerDetailsUploadDownloadResult existingResult = customerDetailsUploadDownloadResultRepository.findById(id).orElse(null);
        if (result.getDate() != null) {
            existingResult.setDate(result.getDate());
        }
        if (result.getExtra_costs() != null) {
            existingResult.setExtra_costs(result.getExtra_costs());
        }

        customerDetailsUploadDownloadResultRepository.save(existingResult);
    }

    public void deleteResult(long customerDetailsId, long uploadDownloadId) {
        CustomerDetailsUploadDownloadResultKey id = new CustomerDetailsUploadDownloadResultKey(customerDetailsId, uploadDownloadId);
        if (!customerDetailsUploadDownloadResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        customerDetailsUploadDownloadResultRepository.deleteById(id);
    }

}
 */