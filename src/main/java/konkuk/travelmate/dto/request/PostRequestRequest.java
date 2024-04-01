package konkuk.travelmate.dto.request;

import konkuk.travelmate.domain.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static konkuk.travelmate.domain.RequestState.*;

public record PostRequestRequest(TravelType type, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {

    public Request toEntity(User disabled, Course course) {
        return Request.builder()
                .type(type())
                .state(PENDING)
                .startTime(Timestamp.valueOf(LocalDateTime.of(startDate, startTime)))
                .endTime(Timestamp.valueOf(LocalDateTime.of(endDate, endTime)))
                .disabled(disabled)
                .course(course)
                .build();
    }


}
