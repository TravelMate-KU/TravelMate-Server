package konkuk.travelmate.form.request;

import konkuk.travelmate.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

import static konkuk.travelmate.domain.RequestState.*;

@Getter
@AllArgsConstructor
public class RequestsRequest {

    private TravelType type;

    private Timestamp startTime;

    private Timestamp endTime;

    public Request toEntity(User disabled, Course course) {
        return Request.builder()
                .type(getType())
                .state(PENDING)
                .startTime(getStartTime())
                .endTime(endTime)
                .disabled(disabled)
                .course(course)
                .build();
    }

}
