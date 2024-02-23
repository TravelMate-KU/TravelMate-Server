package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Health {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "h_id")
    private Long healthId;

    @NonNull
    private Integer walk;

    @NonNull
    private Integer see;

    @NonNull
    private Integer talk;

    @NonNull
    private Integer listen;

    @NonNull
    private Integer depression;

    @NonNull
    private Integer bipolarDisorder;

    @NonNull
    private Integer iq;

    public static Health getDummyHealth(){
        return new Health(0,0,0,0,0,0,0);
    }

}
