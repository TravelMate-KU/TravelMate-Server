package konkuk.travelmate.repository;

import konkuk.travelmate.domain.Request;
import konkuk.travelmate.dto.response.GetRequestsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query("SELECT new konkuk.travelmate.dto.response.GetRequestsResponse(r.requestId, d.name, r.type, c.name, r.startTime, r.endTime)" +
            "FROM Request r " +
            "join r.course c  " +
            "join c.health h " +
            "join r.disabled d " +
            "WHERE r.state = 4 " +
            "and h.bipolarDisorder >= :bipolarDisorder " +
            "and h.depression >= :depression " +
            "and h.iq >= :iq " +
            "and h.listen >= :listen " +
            "and h.see >= :see " +
            "and h.talk >= :talk " +
            "and h.walk >= :walk ")
    List<GetRequestsResponse> findRequestsByStateAndHealthLevel(
            @Param("bipolarDisorder") int bipolarDisorder,
            @Param("depression") int depression,
            @Param("iq") int iq,
            @Param("listen") int listen,
            @Param("see") int see,
            @Param("talk") int talk,
            @Param("walk") int walk);

}
