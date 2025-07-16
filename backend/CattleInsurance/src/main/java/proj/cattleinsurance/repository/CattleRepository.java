package proj.cattleinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.cattleinsurance.entity.Cattle;

import java.util.List;
import java.util.Optional;

@Repository
public interface CattleRepository extends JpaRepository<Cattle, Long> {
    
    // Find cattle by tag number
    Optional<Cattle> findByTagNumber(String tagNumber);
    
    // Find cattle by owner ID
    List<Cattle> findByOwnerId(Long ownerId);
    
    // Find cattle by breed
    List<Cattle> findByBreed(String breed);
    
    // Find cattle by status
    List<Cattle> findByStatus(String status);
    
    // Custom query to find cattle by owner and status
    @Query("SELECT c FROM Cattle c WHERE c.ownerId = :ownerId AND c.status = :status")
    List<Cattle> findByOwnerIdAndStatus(@Param("ownerId") Long ownerId, @Param("status") String status);
    
    // Count cattle by owner
    long countByOwnerId(Long ownerId);
} 