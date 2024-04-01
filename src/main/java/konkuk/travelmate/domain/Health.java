package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

import static java.lang.Integer.parseInt;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    private Integer bipolarDisorder;

    private Integer iq;

    @Builder
    private Health(Integer walk, Integer see, Integer talk, Integer listen, Integer depression, Integer bipolarDisorder, Integer iq) {
        this.walk = walk;
        this.see = see;
        this.talk = talk;
        this.listen = listen;
        this.depression = depression;
        this.bipolarDisorder = bipolarDisorder;
        this.iq = iq;
    }

    public static Health of(Map<String, String> signupMap) {
        return Health.builder()
                .walk(parseInt(signupMap.get("walk")))
                .see(parseInt(signupMap.get("see")))
                .talk(parseInt(signupMap.get("talk")))
                .listen(parseInt(signupMap.get("listen")))
                .depression(parseInt(signupMap.get("depression")))
                .bipolarDisorder(parseInt(signupMap.get("bipolarDisorder")))
                .iq(parseInt(signupMap.get("iq")))
                .build();
    }
}
