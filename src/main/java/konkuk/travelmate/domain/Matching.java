package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Matching {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private Long matchingId;

    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    private User volunteer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "r_id")
    private Request request;

    private Matching(Integer rating, User volunteer, Request request) {
        this.rating = rating;
        this.volunteer = volunteer;
        this.request = request;
    }

    public static Matching createNullRatingMatching(User volunteer, Request request) {
        return new Matching(null, volunteer, request);
    }
}
