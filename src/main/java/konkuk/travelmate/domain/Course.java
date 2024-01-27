package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long courseId;

    private String name;

    private String region;

    private String description;

    @Column(name = "imageUrl")
    private String imageUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "h_id")
    private Health health;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Course2Travel_Component",
            joinColumns = @JoinColumn(name = "c_id"),
            inverseJoinColumns = @JoinColumn(name = "tc_id"))
    private List<TravelComponent> travelComponents;
}
