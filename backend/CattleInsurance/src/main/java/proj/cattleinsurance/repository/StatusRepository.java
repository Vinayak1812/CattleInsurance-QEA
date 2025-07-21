package proj.cattleinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.cattleinsurance.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByStatusName(String statusName);
} 