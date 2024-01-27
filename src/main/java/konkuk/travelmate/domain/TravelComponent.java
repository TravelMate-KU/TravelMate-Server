package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Travel_Component")
@Getter
@NoArgsConstructor
public class TravelComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tc_id")
    private Long travelComponentId;

    private String name;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "travel_type")
    private String travelType;
}
