package proj.cattleinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.cattleinsurance.entity.Cattle;
import proj.cattleinsurance.repository.CattleRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cattle")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
public class CattleController {
    
    @Autowired
    private CattleRepository cattleRepository;
    
    // Get all cattle
    @GetMapping
    public ResponseEntity<List<Cattle>> getAllCattle() {
        try {
            List<Cattle> cattleList = cattleRepository.findAll();
            return new ResponseEntity<>(cattleList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get cattle by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cattle> getCattleById(@PathVariable("id") Long id) {
        Optional<Cattle> cattleData = cattleRepository.findById(id);
        
        if (cattleData.isPresent()) {
            return new ResponseEntity<>(cattleData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Get cattle by owner ID
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Cattle>> getCattleByOwnerId(@PathVariable("ownerId") Long ownerId) {
        try {
            List<Cattle> cattleList = cattleRepository.findByOwnerId(ownerId);
            return new ResponseEntity<>(cattleList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get cattle by tag number
    @GetMapping("/tag/{tagNumber}")
    public ResponseEntity<Cattle> getCattleByTagNumber(@PathVariable("tagNumber") String tagNumber) {
        Optional<Cattle> cattleData = cattleRepository.findByTagNumber(tagNumber);
        
        if (cattleData.isPresent()) {
            return new ResponseEntity<>(cattleData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Create new cattle
    @PostMapping
    public ResponseEntity<Cattle> createCattle(@RequestBody Cattle cattle) {
        try {
            Cattle _cattle = cattleRepository.save(cattle);
            return new ResponseEntity<>(_cattle, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Update cattle
    @PutMapping("/{id}")
    public ResponseEntity<Cattle> updateCattle(@PathVariable("id") Long id, @RequestBody Cattle cattle) {
        Optional<Cattle> cattleData = cattleRepository.findById(id);
        
        if (cattleData.isPresent()) {
            Cattle _cattle = cattleData.get();
            _cattle.setTagNumber(cattle.getTagNumber());
            _cattle.setBreed(cattle.getBreed());
            _cattle.setBirthDate(cattle.getBirthDate());
            _cattle.setGender(cattle.getGender());
            _cattle.setWeight(cattle.getWeight());
            _cattle.setValue(cattle.getValue());
            _cattle.setOwnerId(cattle.getOwnerId());
            _cattle.setStatus(cattle.getStatus());
            
            return new ResponseEntity<>(cattleRepository.save(_cattle), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Delete cattle
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCattle(@PathVariable("id") Long id) {
        try {
            cattleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Test database connection
    @GetMapping("/test")
    public ResponseEntity<String> testConnection() {
        try {
            long count = cattleRepository.count();
            return new ResponseEntity<>("Database connection successful! Total cattle records: " + count, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Database connection failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
} 