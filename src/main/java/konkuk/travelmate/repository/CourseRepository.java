package konkuk.travelmate.repository;

import konkuk.travelmate.domain.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Override
    @EntityGraph(attributePaths = {"health"})
    Optional<Course> findById(Long courseId);
}
