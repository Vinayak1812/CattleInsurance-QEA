package proj.cattleinsurance.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "policy")
public class Policy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(name = "status_id", nullable = false)
    private Long statusId;
    
    @Column(name = "junior_admin_id")
    private Long juniorAdminId;
    
    @Column(name = "senior_admin_id")
    private Long seniorAdminId;
    
    @Column(name = "policy_id", nullable = false)
    private Long policyId;
    
    @Column(name = "cattle_id", nullable = false)
    private Long cattleId;
    
    @Column(name = "premium_amount")
    private Double premiumAmount;
    
    @Column(name = "coverage_amount")
    private Double coverageAmount;
    
    @Column(name = "comments")
    private String comments;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Default constructor
    public Policy() {
        this.createdAt = LocalDateTime.now();
    }
    
    // Constructor with parameters
    public Policy(Long userId, Long statusId, Long policyId, Long cattleId, Double premiumAmount, Double coverageAmount) {
        this.userId = userId;
        this.statusId = statusId;
        this.policyId = policyId;
        this.cattleId = cattleId;
        this.premiumAmount = premiumAmount;
        this.coverageAmount = coverageAmount;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getApplicationId() {
        return applicationId;
    }
    
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getStatusId() {
        return statusId;
    }
    
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
    
    public Long getJuniorAdminId() {
        return juniorAdminId;
    }
    
    public void setJuniorAdminId(Long juniorAdminId) {
        this.juniorAdminId = juniorAdminId;
    }
    
    public Long getSeniorAdminId() {
        return seniorAdminId;
    }
    
    public void setSeniorAdminId(Long seniorAdminId) {
        this.seniorAdminId = seniorAdminId;
    }
    
    public Long getPolicyId() {
        return policyId;
    }
    
    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
    
    public Long getCattleId() {
        return cattleId;
    }
    
    public void setCattleId(Long cattleId) {
        this.cattleId = cattleId;
    }
    
    public Double getPremiumAmount() {
        return premiumAmount;
    }
    
    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
    
    public Double getCoverageAmount() {
        return coverageAmount;
    }
    
    public void setCoverageAmount(Double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }
    
    public String getComments() {
        return comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
} 