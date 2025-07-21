package proj.cattleinsurance.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cattle")
public class Cattle {
    
    @Id
    @Column(name = "cattle_tag")
    private String cattleTag;
    
    @Column(name = "user_id", nullable = false)
    private Long userId; // owner id
    
    @Column(name = "cattle_type", nullable = false)
    private String cattleType;
    
    @Column(name = "breed", nullable = false)
    private String breed;
    
    @Column(name = "policy_id")
    private Long policyId;
    
    @Column(name = "birth_date")
    private LocalDate birthDate;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
    // Default constructor
    public Cattle() {}
    
    // Constructor with parameters
    public Cattle(String cattleTag, Long userId, String cattleType, String breed, Long policyId, LocalDate birthDate, String gender) {
        this.cattleTag = cattleTag;
        this.userId = userId;
        this.cattleType = cattleType;
        this.breed = breed;
        this.policyId = policyId;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    
    // Getters and Setters
    public String getCattleTag() {
        return cattleTag;
    }
    
    public void setCattleTag(String cattleTag) {
        this.cattleTag = cattleTag;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getCattleType() {
        return cattleType;
    }
    
    public void setCattleType(String cattleType) {
        this.cattleType = cattleType;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public Long getPolicyId() {
        return policyId;
    }
    
    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
} 