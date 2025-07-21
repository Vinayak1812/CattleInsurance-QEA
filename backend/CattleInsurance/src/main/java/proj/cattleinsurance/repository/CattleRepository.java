package proj.cattleinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.cattleinsurance.entity.Cattle;

import java.util.List;
import java.util.Optional;

@Repository
public interface CattleRepository extends JpaRepository<Cattle, String> {
    
    // Find cattle by tag number
    Optional<Cattle> findByCattleTag(String cattleTag);
    
    // Find cattle by user ID (owner)
    List<Cattle> findByUserId(Long userId);
    
    // Find cattle by breed
    List<Cattle> findByBreed(String breed);
    
    // Find cattle by cattle type
    List<Cattle> findByCattleType(String cattleType);
    
    // Find cattle by policy ID
    List<Cattle> findByPolicyId(Long policyId);
    
    // Custom query to find cattle by user and breed
    @Query("SELECT c FROM Cattle c WHERE c.userId = :userId AND c.breed = :breed")
    List<Cattle> findByUserIdAndBreed(@Param("userId") Long userId, @Param("breed") String breed);
    
    // Count cattle by user
    long countByUserId(Long userId);
} 