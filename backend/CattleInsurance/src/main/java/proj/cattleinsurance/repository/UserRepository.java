package proj.cattleinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.cattleinsurance.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPasswordHash(String username, String passwordHash);
    User findByUsername(String username);
} 