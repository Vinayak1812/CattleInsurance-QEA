package proj.cattleinsurance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    
    @Column(name = "address_street", nullable = false)
    private String addressStreet;
    
    @Column(name = "address_city", nullable = false)
    private String addressCity;
    
    @Column(name = "address_pin_code", nullable = false)
    private String addressPinCode;
    
    @Column(name = "address_state", nullable = false)
    private String addressState;
    
    @Column(name = "region_id")
    private Long regionId;
    
    // Default constructor
    public Address() {}
    
    // Constructor with parameters
    public Address(String addressStreet, String addressCity, String addressPinCode, String addressState, Long regionId) {
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressPinCode = addressPinCode;
        this.addressState = addressState;
        this.regionId = regionId;
    }
    
    // Getters and Setters
    public Long getAddressId() {
        return addressId;
    }
    
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
    
    public String getAddressStreet() {
        return addressStreet;
    }
    
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }
    
    public String getAddressCity() {
        return addressCity;
    }
    
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
    
    public String getAddressPinCode() {
        return addressPinCode;
    }
    
    public void setAddressPinCode(String addressPinCode) {
        this.addressPinCode = addressPinCode;
    }
    
    public String getAddressState() {
        return addressState;
    }
    
    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }
    
    public Long getRegionId() {
        return regionId;
    }
    
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }
} 