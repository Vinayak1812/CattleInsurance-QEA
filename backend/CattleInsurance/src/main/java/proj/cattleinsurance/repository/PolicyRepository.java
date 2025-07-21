package proj.cattleinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.cattleinsurance.entity.Policy;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByStatusId(Long statusId);
    List<Policy> findByUserId(Long userId);
} 