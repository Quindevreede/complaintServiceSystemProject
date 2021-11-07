package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.ProductionComplaint;
import nl.quin.complaintservicesystem.repository.CustomerComplaintRepository;
import nl.quin.complaintservicesystem.repository.ProductionComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class ProductionComplaintService {

    @Autowired
    ProductionComplaintRepository productionComplaintRepository;

    @Autowired
    UserService username;

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
        productionComplaint.setUsername(username.getCurrentUserName()); //TODO if no currentUserName? kan deze in uiteindelijke???
        ProductionComplaint storedProductionComplaint = productionComplaintRepository.save(productionComplaint);
        return storedProductionComplaint.getId();
    }

    public void updateProductionComplaint(long id, ProductionComplaint productionComplaint) {
        if (!productionComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        ProductionComplaint storedProductionComplaint = productionComplaintRepository.findById(id).orElse(null);
        storedProductionComplaint.setUsername(username.getCurrentUserName());
        storedProductionComplaint.setOrderNumber(productionComplaint.getOrderNumber());
        storedProductionComplaint.setProductionCommentary(productionComplaint.getProductionCommentary());
        productionComplaintRepository.save(productionComplaint);
    }

    public void partialUpdateProductionComplaint(long id, Map<String, String> fields) {
        if (!productionComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        ProductionComplaint storedProductionComplaint = productionComplaintRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "order_number":
                    storedProductionComplaint.setOrderNumber((String) fields.get(field));
                    break;
                case "production_commentary":
                    storedProductionComplaint.setProductionCommentary((String) fields.get(field));
                    break;
                case "production_complaint":
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