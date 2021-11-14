package nl.quin.complaintservicesystem.payload.request;

import org.springframework.web.multipart.MultipartFile;

public class ReceiptUploadRequestDto {
        private String ordernumber;
        private MultipartFile file;

        // GETTERS SETTERS

        public String getOrdernumber() {
                return ordernumber;
        }

        public void setOrdernumber(String ordernumber) {
                this.ordernumber = ordernumber;
        }

        public MultipartFile getFile() {
                return file;
        }

        public void setFile(MultipartFile file) {
                this.file = file;
        }

}
