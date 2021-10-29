package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.UploadDownload;
import org.springframework.data.repository.CrudRepository;

public interface UploadDownloadRepository extends CrudRepository<UploadDownload, Long> {
}
