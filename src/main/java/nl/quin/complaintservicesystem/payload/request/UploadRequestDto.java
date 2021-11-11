package nl.quin.complaintservicesystem.payload.request;

import org.springframework.web.multipart.MultipartFile;

public class UploadRequestDto {
        private String title;
        private String description;
        private String orderNumberUpload;
        private MultipartFile file;

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

        public String getOrderNumberUpload() {
                return orderNumberUpload;
        }

        public void setOrderNumberUpload(String orderNumberUpload) {
                this.orderNumberUpload = orderNumberUpload;
        }

        public MultipartFile getFile() {
                return file;
        }

        public void setFile(MultipartFile file) {
                this.file = file;
        }


}
