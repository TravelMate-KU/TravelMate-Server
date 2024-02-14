package konkuk.travelmate.repository;

import konkuk.travelmate.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
