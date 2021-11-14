package nl.quin.complaintservicesystem.payload.request;

import org.springframework.web.multipart.MultipartFile;

public class ReceiptUploadRequestDto {
        private String ordernumber;
        private String uploadedByEmployee;
        private MultipartFile file;

        // GETTERS SETTERS

        public String getOrdernumber() {
                return ordernumber;
        }

        public void setOrdernumber(String ordernumber) {
                this.ordernumber = ordernumber;
        }

        public String getUploadedByEmployee() { return uploadedByEmployee; }

        public void setUploadedByEmployee(String uploadedByEmployee) { this.uploadedByEmployee = uploadedByEmployee; }

        public MultipartFile getFile() {
                return file;
        }

        public void setFile(MultipartFile file) {
                this.file = file;
        }

}
