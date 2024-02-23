package konkuk.travelmate.repository;

import konkuk.travelmate.domain.Health;
import konkuk.travelmate.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthRepository extends JpaRepository<Health, Long> {

    @Override
    @EntityGraph(attributePaths = {"health"})
    Optional<Health> findById(Long userId);


}
