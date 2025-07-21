package proj.cattleinsurance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "document")
public class Document {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long documentId;
    
    @Column(name = "document_name", nullable = false)
    private String documentName;
    
    @Column(name = "application_id", nullable = false)
    private Long applicationId;
    
    @Column(name = "file_path")
    private String filePath;
    
    @Column(name = "file_type")
    private String fileType;
    
    @Column(name = "file_size")
    private Long fileSize;
    
    @Column(name = "upload_date")
    private java.time.LocalDateTime uploadDate;
    
    // Default constructor
    public Document() {
        this.uploadDate = java.time.LocalDateTime.now();
    }
    
    // Constructor with parameters
    public Document(String documentName, Long applicationId, String filePath, String fileType, Long fileSize) {
        this.documentName = documentName;
        this.applicationId = applicationId;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.uploadDate = java.time.LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getDocumentId() {
        return documentId;
    }
    
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }
    
    public String getDocumentName() {
        return documentName;
    }
    
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
    
    public Long getApplicationId() {
        return applicationId;
    }
    
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public String getFileType() {
        return fileType;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    public Long getFileSize() {
        return fileSize;
    }
    
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
    
    public java.time.LocalDateTime getUploadDate() {
        return uploadDate;
    }
    
    public void setUploadDate(java.time.LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }
} 