package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long userId;

    @NonNull
    private String name;

    private String email;

    @NonNull
    private String password;

    @NonNull
    private String phoneNum;

    @NonNull
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "h_id")
    @NonNull
    private Health health;

    public void setHealth(Health health){
        this.health=health;
    }

}
