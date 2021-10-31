/*package nl.quin.complaintservicesystem.service;

  import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;

  import nl.quin.complaintservicesystem.model.CustomerComplaintDetails;
  import nl.quin.complaintservicesystem.model.CustomerComplaintDetailsProductionComplaintDetailsResult;
  import nl.quin.complaintservicesystem.model.CustomerComplaintDetailsProductionComplaintDetailsResultKey;
  import nl.quin.complaintservicesystem.model.ProductionComplaintDetails;
  import nl.quin.complaintservicesystem.repository.CustomerComplaintDetailsProductionComplaintDetailsResultRepository;
  import nl.quin.complaintservicesystem.repository.CustomerComplaintDetailsRepository;
  import nl.quin.complaintservicesystem.repository.ProductionComplaintDetailsRepository;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;

  import java.util.Collection;

@Service
public class CustomerComplaintDetailsProductionComplaintDetailsResultService {

    @Autowired
    ProductionComplaintDetailsRepository productionComplaintDetailsRepository;

    @Autowired
    CustomerComplaintDetailsRepository customerComplaintDetailsRepository;

    @Autowired
    CustomerComplaintDetailsProductionComplaintDetailsResultRepository customerComplaintDetailsProductionComplaintDetailsResultRepository;

    public Collection<CustomerComplaintDetailsProductionComplaintDetailsResult> getAllResults() {
        Collection<CustomerComplaintDetailsProductionComplaintDetailsResult> results = customerComplaintDetailsProductionComplaintDetailsResultRepository.findAll();
        return results;
    }

    public Collection<CustomerComplaintDetailsProductionComplaintDetailsResult> getResultsByCustomerComplaintDetailsId(long customerComplaintDetailsId) {
        return customerComplaintDetailsProductionComplaintDetailsResultRepository.findAllByCustomerComplaintDetailsId(customerComplaintDetailsId);
    }

    public Collection<CustomerComplaintDetailsProductionComplaintDetailsResult> getResultsByProductionComplaintDetailsId(long productionComplaintDetailsId) {
        return customerComplaintDetailsProductionComplaintDetailsResultRepository.findAllByProductionComplaintDetailsId(productionComplaintDetailsId);
    }

    public CustomerComplaintDetailsProductionComplaintDetailsResult getResultById(long customerComplaintDetailsId, long productionComplaintDetailsId) {
        return customerComplaintDetailsProductionComplaintDetailsResultRepository.findById(new CustomerComplaintDetailsProductionComplaintDetailsResultKey(customerComplaintDetailsId, new ProductionComplaintDetails(""))).orElse(null);
    }

    public CustomerComplaintDetailsProductionComplaintDetailsResultKey addResult(long customerComplaintDetailsId, long productionComplaintDetailsId, CustomerComplaintDetailsProductionComplaintDetailsResult result) {
        if (!customerComplaintDetailsRepository.existsById(customerComplaintDetailsId)) { throw new RecordNotFoundException(); }
        CustomerComplaintDetails customerComplaintDetails = customerComplaintDetailsRepository.findById(customerComplaintDetailsId).orElse(null);
        if (!productionComplaintDetailsRepository.existsById(productionComplaintDetailsId)) { throw new RecordNotFoundException(); }
        ProductionComplaintDetails productionComplaintDetails = productionComplaintDetailsRepository.findById(productionComplaintDetailsId).orElse(null);
        result.setCustomerComplaintDetails(customerComplaintDetails);
        result.setProductionComplaintDetails(productionComplaintDetails);
        CustomerComplaintDetailsProductionComplaintDetailsResultKey id = new CustomerComplaintDetailsProductionComplaintDetailsResultKey(customerComplaintDetailsId, productionComplaintDetailsId);
        result.setId(id);
        customerComplaintDetailsProductionComplaintDetailsResultRepository.save(result);
        return id;
    }

    public void updateResult(long customerComplaintDetailsId, long productionComplaintDetailsId, CustomerComplaintDetailsProductionComplaintDetailsResult result) {
        CustomerComplaintDetailsProductionComplaintDetailsResultKey id = new CustomerComplaintDetailsProductionComplaintDetailsResultKey(customerComplaintDetailsId, productionComplaintDetailsId);
        if (!customerComplaintDetailsProductionComplaintDetailsResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        CustomerComplaintDetailsProductionComplaintDetailsResult existingResult = customerComplaintDetailsProductionComplaintDetailsResultRepository.findById(id).orElse(null);
        existingResult.setDate(result.getDate());
        existingResult.setExtra_costs(result.getExtra_costs());
        customerComplaintDetailsProductionComplaintDetailsResultRepository.save(existingResult);
    }

    public void partialUpdateResult(long customerComplaintDetailsId, long productionComplaintDetailsId, CustomerComplaintDetailsProductionComplaintDetailsResult result) {
        CustomerComplaintDetailsProductionComplaintDetailsResultKey id = new CustomerComplaintDetailsProductionComplaintDetailsResultKey(customerComplaintDetailsId, productionComplaintDetailsId);
        if (!customerComplaintDetailsProductionComplaintDetailsResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        CustomerComplaintDetailsProductionComplaintDetailsResult existingResult = customerComplaintDetailsProductionComplaintDetailsResultRepository.findById(id).orElse(null);
        if (result.getDate() != null) {
            existingResult.setDate(result.getDate());
        }
        if (result.getExtra_costs() != null) {
            existingResult.setExtra_costs(result.getExtra_costs());
        }

        customerComplaintDetailsProductionComplaintDetailsResultRepository.save(existingResult);
    }

    public void deleteResult(long customerComplaintDetailsId, long productionComplaintDetailsId) {
        CustomerComplaintDetailsProductionComplaintDetailsResultKey id = new CustomerComplaintDetailsProductionComplaintDetailsResultKey(customerComplaintDetailsId, productionComplaintDetailsId);
        if (!customerComplaintDetailsProductionComplaintDetailsResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        customerComplaintDetailsProductionComplaintDetailsResultRepository.deleteById(id);
    }

}

 */