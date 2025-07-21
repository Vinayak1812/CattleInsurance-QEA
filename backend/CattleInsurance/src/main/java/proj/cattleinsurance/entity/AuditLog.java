package proj.cattleinsurance.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;
    
    @Column(name = "application_id", nullable = false)
    private Long applicationId;
    
    @Column(name = "action_by", nullable = false)
    private Long actionBy; // user id
    
    @Column(name = "action_id", nullable = false)
    private Long actionId;
    
    @Column(name = "role_id", nullable = false)
    private Long roleId;
    
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
    
    @Column(name = "details")
    private String details;
    
    // Default constructor
    public AuditLog() {
        this.timestamp = LocalDateTime.now();
    }
    
    // Constructor with parameters
    public AuditLog(Long applicationId, Long actionBy, Long actionId, Long roleId, String details) {
        this.applicationId = applicationId;
        this.actionBy = actionBy;
        this.actionId = actionId;
        this.roleId = roleId;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getLogId() {
        return logId;
    }
    
    public void setLogId(Long logId) {
        this.logId = logId;
    }
    
    public Long getApplicationId() {
        return applicationId;
    }
    
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
    
    public Long getActionBy() {
        return actionBy;
    }
    
    public void setActionBy(Long actionBy) {
        this.actionBy = actionBy;
    }
    
    public Long getActionId() {
        return actionId;
    }
    
    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }
    
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getDetails() {
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
} 