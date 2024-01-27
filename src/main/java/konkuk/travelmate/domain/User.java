package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long userId;

    private String email;

    private String password;

    @Column(name = "phone_num")
    private String phoneNum;

    /**
     * DISABLED, VOLUNTEER
     */
    private String role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "h_id")
    private Health health;
}
