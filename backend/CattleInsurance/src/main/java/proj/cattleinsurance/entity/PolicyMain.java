package proj.cattleinsurance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "policy_main")
public class PolicyMain {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyId;
    
    @Column(name = "policy_name", nullable = false)
    private String policyName;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "premium_amount")
    private Double premiumAmount;
    
    @Column(name = "coverage_amount")
    private Double coverageAmount;
    
    @Column(name = "duration_months")
    private Integer durationMonths;
    
    // Default constructor
    public PolicyMain() {}
    
    // Constructor with parameters
    public PolicyMain(String policyName, String description, Double premiumAmount, Double coverageAmount, Integer durationMonths) {
        this.policyName = policyName;
        this.description = description;
        this.premiumAmount = premiumAmount;
        this.coverageAmount = coverageAmount;
        this.durationMonths = durationMonths;
    }
    
    // Getters and Setters
    public Long getPolicyId() {
        return policyId;
    }
    
    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
    
    public String getPolicyName() {
        return policyName;
    }
    
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
    
    public Integer getDurationMonths() {
        return durationMonths;
    }
    
    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }
} 