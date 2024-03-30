package konkuk.travelmate.repository;

import konkuk.travelmate.domain.Matching;
import konkuk.travelmate.dto.response.GetVolunteerMatchingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchingRepository extends JpaRepository<Matching, Long> {
    @Query("SELECT new konkuk.travelmate.dto.response.GetVolunteerMatchingDto(d.name, r.startTime, r.endTime, r.type, r.state, d.phoneNum, d.email) " +
            "FROM Request r JOIN r.disabled d " +
            "WHERE d.role = 0 AND r.requestId IN ( " +
            "SELECT m.request.requestId " +
            "FROM Matching m JOIN m.volunteer v " +
            "WHERE v.email = :email)")
    List<GetVolunteerMatchingDto> findVolunteerMatchingResultsByEmail(@Param("email") String email);
}
