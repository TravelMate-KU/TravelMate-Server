package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
public class CourseTravelComponent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_tc_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "c_id")
    private Course course;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "tc_id")
    private TravelComponent travelComponent;

}
