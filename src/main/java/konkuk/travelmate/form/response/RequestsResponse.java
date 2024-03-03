package konkuk.travelmate.form.response;

import konkuk.travelmate.domain.TravelType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public record RequestsResponse(String disabledName, TravelType requestsType, String courseName, Timestamp startTime, Timestamp endTime) {

}
