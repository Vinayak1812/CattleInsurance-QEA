package proj.cattleinsurance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;
    
    @Column(name = "status_name", nullable = false)
    private String statusName; // PENDING, APPROVED, REJECTED, etc.
    
    @Column(name = "description")
    private String description;
    
    // Default constructor
    public Status() {}
    
    // Constructor with parameters
    public Status(String statusName, String description) {
        this.statusName = statusName;
        this.description = description;
    }
    
    // Getters and Setters
    public Long getStatusId() {
        return statusId;
    }
    
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
    
    public String getStatusName() {
        return statusName;
    }
    
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
} 