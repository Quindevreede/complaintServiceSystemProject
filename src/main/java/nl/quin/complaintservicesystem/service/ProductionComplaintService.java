package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.ProductionComplaint;
import nl.quin.complaintservicesystem.repository.ProductionComplaintRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionComplaintService {

    @Autowired
    ProductionComplaintRepository productionComplaintRepository;

    @Autowired
    UserService username;

    @Autowired
    CustomerComplaintService getOrderNumber;

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

    public void deleteProductionComplaint(long id) {
        if (!productionComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        productionComplaintRepository.deleteById(id);
    }

}