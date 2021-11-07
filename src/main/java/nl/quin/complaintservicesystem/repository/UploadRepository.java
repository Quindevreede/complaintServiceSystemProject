package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.Upload;
import org.springframework.data.repository.CrudRepository;

public interface UploadRepository extends CrudRepository<Upload, Long> {
}
