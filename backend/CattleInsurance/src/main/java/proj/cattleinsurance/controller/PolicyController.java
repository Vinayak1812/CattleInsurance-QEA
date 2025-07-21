package proj.cattleinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.cattleinsurance.entity.Policy;
import proj.cattleinsurance.entity.Status;
import proj.cattleinsurance.repository.PolicyRepository;
import proj.cattleinsurance.repository.StatusRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin(origins = "http://localhost:3000")
public class PolicyController {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/pending-junior")
    public ResponseEntity<List<Policy>> getPendingJuniorApproval() {
        // Get policies with status "PENDING" (status_id = 1)
        List<Policy> pendingPolicies = policyRepository.findByStatusId(1L);
        return ResponseEntity.ok(pendingPolicies);
    }

    @GetMapping("/pending-senior")
    public ResponseEntity<List<Policy>> getPendingSeniorApproval() {
        // Get policies with status "JUNIOR_APPROVED" (status_id = 2)
        List<Policy> juniorApprovedPolicies = policyRepository.findByStatusId(2L);
        return ResponseEntity.ok(juniorApprovedPolicies);
    }

    @PostMapping("/{applicationId}/junior-approve")
    public ResponseEntity<?> juniorApprove(@PathVariable Long applicationId, @RequestBody Map<String, String> request) {
        Policy policy = policyRepository.findById(applicationId).orElse(null);
        if (policy == null) {
            return ResponseEntity.notFound().build();
        }

        String comments = request.get("comments");
        Long juniorAdminId = Long.parseLong(request.get("adminId"));

        policy.setStatusId(2L); // JUNIOR_APPROVED
        policy.setJuniorAdminId(juniorAdminId);
        policy.setComments(comments);
        policy.setUpdatedAt(LocalDateTime.now());

        policyRepository.save(policy);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Policy approved by Junior Admin");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{applicationId}/junior-reject")
    public ResponseEntity<?> juniorReject(@PathVariable Long applicationId, @RequestBody Map<String, String> request) {
        Policy policy = policyRepository.findById(applicationId).orElse(null);
        if (policy == null) {
            return ResponseEntity.notFound().build();
        }

        String comments = request.get("comments");
        Long juniorAdminId = Long.parseLong(request.get("adminId"));

        policy.setStatusId(4L); // REJECTED
        policy.setJuniorAdminId(juniorAdminId);
        policy.setComments(comments);
        policy.setUpdatedAt(LocalDateTime.now());

        policyRepository.save(policy);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Policy rejected by Junior Admin");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{applicationId}/senior-approve")
    public ResponseEntity<?> seniorApprove(@PathVariable Long applicationId, @RequestBody Map<String, String> request) {
        Policy policy = policyRepository.findById(applicationId).orElse(null);
        if (policy == null) {
            return ResponseEntity.notFound().build();
        }

        String comments = request.get("comments");
        Long seniorAdminId = Long.parseLong(request.get("adminId"));

        policy.setStatusId(3L); // APPROVED
        policy.setSeniorAdminId(seniorAdminId);
        policy.setComments(comments);
        policy.setUpdatedAt(LocalDateTime.now());

        policyRepository.save(policy);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Policy approved by Senior Admin");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{applicationId}/senior-reject")
    public ResponseEntity<?> seniorReject(@PathVariable Long applicationId, @RequestBody Map<String, String> request) {
        Policy policy = policyRepository.findById(applicationId).orElse(null);
        if (policy == null) {
            return ResponseEntity.notFound().build();
        }

        String comments = request.get("comments");
        Long seniorAdminId = Long.parseLong(request.get("adminId"));

        policy.setStatusId(4L); // REJECTED
        policy.setSeniorAdminId(seniorAdminId);
        policy.setComments(comments);
        policy.setUpdatedAt(LocalDateTime.now());

        policyRepository.save(policy);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Policy rejected by Senior Admin");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/apply")
    public ResponseEntity<?> applyPolicy(@RequestBody Policy policyRequest) {
        policyRequest.setStatusId(1L); // PENDING
        policyRequest.setCreatedAt(LocalDateTime.now());
        
        Policy savedPolicy = policyRepository.save(policyRequest);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("applicationId", savedPolicy.getApplicationId());
        response.put("message", "Policy application submitted successfully");
        return ResponseEntity.ok(response);
    }
} 