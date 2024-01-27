package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Health {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "h_id")
    private Long healthId;

    private Integer walk;

    private Integer see;

    private Integer talk;

    private Integer listen;

    private Integer depression;

    @Column(name = "bipolar_disorder")
    private Integer bipolarDisorder;

    private Integer iq;

}
