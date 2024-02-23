package konkuk.travelmate.form.request;

import konkuk.travelmate.domain.TravelType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class RequestsRequest {

    private TravelType type;

    private Timestamp startTime;

    private Timestamp endTime;

}
