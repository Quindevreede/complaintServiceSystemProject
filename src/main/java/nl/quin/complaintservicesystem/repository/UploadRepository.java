package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.model.Upload;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface UploadRepository extends CrudRepository<Upload, Long> {
    Collection<CustomerComplaint> findAllByOrderNumberUpload(String orderNumber);
    Optional<Upload> findByOrderNumberUpload(String orderNumberUpload);
    boolean existsByOrderNumberUpload(String orderNumberUpload);
}