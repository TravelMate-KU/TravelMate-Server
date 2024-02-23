package konkuk.travelmate.form.response;

import konkuk.travelmate.domain.TravelType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class RequestsResponse {

    private String disabledName;
    private TravelType requestsType;
    private String courseName;
    private Timestamp startTime;
    private Timestamp endTime;

}
