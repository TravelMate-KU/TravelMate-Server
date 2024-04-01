package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long courseId;

    private String name;

    private String region;

    private String description;

    private String imageUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "h_id")
    private Health health;

    @Builder
    private Course(String name, String region, String description, String imageUrl, Health health) {
        this.name = name;
        this.region = region;
        this.description = description;
        this.imageUrl = imageUrl;
        this.health = health;
    }
}
