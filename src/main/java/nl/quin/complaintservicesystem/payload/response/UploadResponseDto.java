package nl.quin.complaintservicesystem.payload.response;

import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.sql.Timestamp;

public class UploadResponseDto {
        private String title;
        private String fileName;
        private String description;
        private String orderNumberUpload;
        private String downloadUri;
        private String uploadedByUserName;
        private Timestamp uploadedOnDate;

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getFileName() {
                return fileName;
        }

        public void setFileName(String fileName) {
                this.fileName = fileName;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getOrderNumberUpload() { return orderNumberUpload;}

        public void setOrderNumberUpload(String orderNumberUpload) {this.orderNumberUpload = orderNumberUpload;}

        public String getDownloadUri() {
                return downloadUri;
        }

        public void setDownloadUri(String downloadUri) {
                this.downloadUri = downloadUri;
        }

        public String getUploadedByUserName() { return uploadedByUserName;}

        public void setUploadedByUserName(String uploadedByUserName) { this.uploadedByUserName = uploadedByUserName;}

        public Timestamp getUploadedOnDate() {
                return uploadedOnDate;
        }

        public void setUploadedOnDate(Timestamp uploadedOnDate) {
                this.uploadedOnDate = uploadedOnDate;
        }
}
