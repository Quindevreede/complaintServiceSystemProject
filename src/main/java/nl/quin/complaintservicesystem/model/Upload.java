package nl.quin.complaintservicesystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "upload")
public class Upload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "uploaded_by_username")
    private String uploadedByUsername;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUploadedByUsername() {
        return uploadedByUsername;
    }

    public void setUploadedByUsername(String uploadedByUsername) {
        this.uploadedByUsername = uploadedByUsername;
    }
}
