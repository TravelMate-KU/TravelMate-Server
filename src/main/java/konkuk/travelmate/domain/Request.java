package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long requestId;

    private TravelType type;

    private RequestState state;

    private Timestamp startTime;

    private Timestamp endTime;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "u_id")
    private User disabled;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "c_id")
    private Course course;

    public Request(TravelType type, RequestState state, Timestamp startTime, Timestamp endTime, User disabled, Course course) {
        this.type = type;
        this.state = state;
        this.startTime = startTime;
        this.endTime = endTime;
        this.disabled = disabled;
        this.course = course;
    }

    public void changeStateToWait() {
        this.state = RequestState.WAIT;
    }
}
