package konkuk.travelmate.dto.response;

import konkuk.travelmate.domain.TravelType;

import java.sql.Timestamp;

public record GetRequestsDto(Long requestId, String disabledName, TravelType requestsType, String courseName,
                             Timestamp startTime, Timestamp endTime) {

}
