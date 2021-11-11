package nl.quin.complaintservicesystem.payload.response;

import org.springframework.web.multipart.MultipartFile;

public class UploadResponseDto {
        private String title;
        private String description;
        private String fileName;
        private String downloadUri;
        private String uploadedByUserName;

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getFileName() {
                return fileName;
        }

        public void setFileName(String fileName) {
                this.fileName = fileName;
        }

        public String getDownloadUri() {
                return downloadUri;
        }

        public void setDownloadUri(String downloadUri) {
                this.downloadUri = downloadUri;
        }

        public String getUploadedByUserName() { return uploadedByUserName;}

        public void setUploadedByUserName(String uploadedByUserName) { this.uploadedByUserName = uploadedByUserName;}
}
