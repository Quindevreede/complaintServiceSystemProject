package nl.quin.complaintservicesystem.payload.response;

public class ReceiptUploadResponseDto {
        private String ordernumber;
        private String fileName;
        private String downloadUri;
        private String uploadedByEmployee;

        // GETTERS SETTERS

        public String getOrdernumber() {
                return ordernumber;
        }

        public void setOrdernumber(String ordernumber) {
                this.ordernumber = ordernumber;
        }

        public String getUploadedByEmployee() { return uploadedByEmployee; }

        public void setUploadedByEmployee(String uploadedByEmployee) { this.uploadedByEmployee = uploadedByEmployee; }

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

}
