package proj.cattleinsurance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "action")
public class Action {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id")
    private Long actionId;
    
    @Column(name = "action_name", nullable = false)
    private String actionName; // APPROVE, REJECT, SUBMIT, etc.
    
    @Column(name = "description")
    private String description;
    
    // Default constructor
    public Action() {}
    
    // Constructor with parameters
    public Action(String actionName, String description) {
        this.actionName = actionName;
        this.description = description;
    }
    
    // Getters and Setters
    public Long getActionId() {
        return actionId;
    }
    
    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }
    
    public String getActionName() {
        return actionName;
    }
    
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
} 