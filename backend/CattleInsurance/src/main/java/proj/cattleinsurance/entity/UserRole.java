package proj.cattleinsurance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    
    @Column(name = "name", nullable = false)
    private String name; // Farmer, Junior Admin, Senior Admin
    
    // Default constructor
    public UserRole() {}
    
    // Constructor with parameters
    public UserRole(String name) {
        this.name = name;
    }
    
    // Getters and Setters
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
} 