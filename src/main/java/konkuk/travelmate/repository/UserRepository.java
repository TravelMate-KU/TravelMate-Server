package konkuk.travelmate.repository;

import konkuk.travelmate.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @EntityGraph(attributePaths = {"health"})
    Optional<User> findById(Long userId);
}
