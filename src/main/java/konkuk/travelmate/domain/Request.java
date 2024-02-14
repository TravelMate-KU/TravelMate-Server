package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long requestId;

    @Enumerated(value = EnumType.ORDINAL)
    private TravelType type;

    @Enumerated(value = EnumType.ORDINAL)
    private RequestState state;

    private Timestamp startTime;

    private Timestamp endTime;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "u_id")
    private User disabled;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "c_id")
    private Course course;

}
