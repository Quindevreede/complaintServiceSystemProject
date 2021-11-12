package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.model.ProductionComplaint;
import nl.quin.complaintservicesystem.repository.ProductionComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


@Service
public class ProductionComplaintService {

    @Autowired
    ProductionComplaintRepository productionComplaintRepository;

    @Autowired
    UserService username;

    @Autowired
    CustomerComplaintService getOrderNumber;

    public Collection<ProductionComplaint> getAllProductionComplaints() {
        return productionComplaintRepository.findAll();
    }

    public Collection<ProductionComplaint> getProductionComplaint(String name) {
        if (name.isEmpty()) {
            return productionComplaintRepository.findAll();
        }
        else {
            return productionComplaintRepository.findAllByOrderNumber(name);
        }
    }

    public ProductionComplaint getProductionComplaintById(long id) {
        if (!productionComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        return productionComplaintRepository.findById(id).orElse(null);
    }

    public long createProductionComplaint (ProductionComplaint productionComplaint) {
        ProductionComplaint storedProductionComplaint = productionComplaintRepository.save(productionComplaint);
        return storedProductionComplaint.getId();
    }

    public void updateProductionComplaint(long id, ProductionComplaint productionComplaint) {
        if (!productionComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        ProductionComplaint storedProductionComplaint = productionComplaintRepository.findById(id).orElse(null);
        storedProductionComplaint.setAssistedBy(productionComplaint.getAssistedBy());
        storedProductionComplaint.setProductionDepartment(productionComplaint.getProductionDepartment());
        storedProductionComplaint.setProductionCommentary(productionComplaint.getProductionCommentary());
        productionComplaintRepository.save(productionComplaint);
    }

    public void updateProductionComplaintPartial(long id, Map<String, String> fields) {
        if (!productionComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        ProductionComplaint storedProductionComplaint = productionComplaintRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "assisted_by":
                    storedProductionComplaint.setAssistedBy((String) fields.get(field));
                    break;
                case "production_department":
                    storedProductionComplaint.setProductionDepartment((String) fields.get(field));
                    break;
                case "production_commentary":
                    storedProductionComplaint.setProductionCommentary((String) fields.get(field));
                    break;
            }
        }

        productionComplaintRepository.save(storedProductionComplaint);
    }

    public void deleteProductionComplaint(long id) {
        if (!productionComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        productionComplaintRepository.deleteById(id);
    }

}