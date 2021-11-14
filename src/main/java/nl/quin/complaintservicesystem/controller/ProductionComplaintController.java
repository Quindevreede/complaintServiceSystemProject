package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.ProductionComplaint;
import nl.quin.complaintservicesystem.service.ProductionComplaintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping(value = "/production_complaint")
public class ProductionComplaintController {

    @Autowired
    private ProductionComplaintService productionComplaintService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getProductionComplaint(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(productionComplaintService.getProductionComplaintById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createProductionComplaint(@RequestBody ProductionComplaint productionComplaint) {
        long newId = productionComplaintService.createProductionComplaint(productionComplaint);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateProductionComplaint(@PathVariable("id") long id, @RequestBody ProductionComplaint productionComplaint) {
        productionComplaintService.updateProductionComplaint(id, productionComplaint);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProductionComplaint(@PathVariable("id") long id) {
        productionComplaintService.deleteProductionComplaint(id);
        return ResponseEntity.noContent().build();
    }

}