package proj.cattleinsurance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "region")
public class Region {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;
    
    @Column(name = "region_name", nullable = false)
    private String regionName;
    
    @Column(name = "description")
    private String description;
    
    // Default constructor
    public Region() {}
    
    // Constructor with parameters
    public Region(String regionName, String description) {
        this.regionName = regionName;
        this.description = description;
    }
    
    // Getters and Setters
    public Long getRegionId() {
        return regionId;
    }
    
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }
    
    public String getRegionName() {
        return regionName;
    }
    
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
} 