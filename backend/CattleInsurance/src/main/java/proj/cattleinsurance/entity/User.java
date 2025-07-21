package proj.cattleinsurance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "role_id", nullable = false)
    private Long roleId;
    
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @Column(name = "address_id")
    private Long addressId;
    
    @Column(name = "contact_no")
    private String contactNo;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    
    @Column(name = "cattle_id")
    private Long cattleId;
    
    @Column(name = "gender")
    private String gender; // Male, Female, Other
    
    // Default constructor
    public User() {}
    
    // Constructor with parameters
    public User(Long roleId, String username, Long addressId, String contactNo, String email, String passwordHash, Long cattleId, String gender) {
        this.roleId = roleId;
        this.username = username;
        this.addressId = addressId;
        this.contactNo = contactNo;
        this.email = email;
        this.passwordHash = passwordHash;
        this.cattleId = cattleId;
        this.gender = gender;
    }
    
    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public Long getAddressId() {
        return addressId;
    }
    
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
    
    public String getContactNo() {
        return contactNo;
    }
    
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPasswordHash() {
        return passwordHash;
    }
    
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    public Long getCattleId() {
        return cattleId;
    }
    
    public void setCattleId(Long cattleId) {
        this.cattleId = cattleId;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
} 