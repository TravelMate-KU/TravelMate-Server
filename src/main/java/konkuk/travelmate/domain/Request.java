package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long requestId;

    private String type;

    private String state;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    private User disabled;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Request2Course",
            joinColumns = @JoinColumn(name = "r_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Course> courses;

}
