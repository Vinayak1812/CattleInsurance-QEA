package proj.cattleinsurance.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cattle")
public class Cattle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tag_number", unique = true, nullable = false)
    private String tagNumber;
    
    @Column(name = "breed", nullable = false)
    private String breed;
    
    @Column(name = "birth_date")
    private LocalDate birthDate;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @Column(name = "weight")
    private Double weight;
    
    @Column(name = "value", nullable = false)
    private Double value;
    
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;
    
    @Column(name = "status")
    private String status = "ACTIVE";
    
    // Default constructor
    public Cattle() {}
    
    // Constructor with parameters
    public Cattle(String tagNumber, String breed, LocalDate birthDate, String gender, Double weight, Double value, Long ownerId) {
        this.tagNumber = tagNumber;
        this.breed = breed;
        this.birthDate = birthDate;
        this.gender = gender;
        this.weight = weight;
        this.value = value;
        this.ownerId = ownerId;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTagNumber() {
        return tagNumber;
    }
    
    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
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
    
    public Double getWeight() {
        return weight;
    }
    
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    public Double getValue() {
        return value;
    }
    
    public void setValue(Double value) {
        this.value = value;
    }
    
    public Long getOwnerId() {
        return ownerId;
    }
    
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
} 