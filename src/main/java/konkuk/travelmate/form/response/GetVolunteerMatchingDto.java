package konkuk.travelmate.form.response;

import konkuk.travelmate.domain.RequestState;
import konkuk.travelmate.domain.TravelType;

import java.sql.Timestamp;

public record GetVolunteerMatchingDto(String disabledName, Timestamp startTime, Timestamp endTime, TravelType type,
                                      RequestState state, String disabledPhoneName, String disabledEmail) {
}
