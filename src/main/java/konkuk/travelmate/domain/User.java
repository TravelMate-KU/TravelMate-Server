package konkuk.travelmate.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private Health health;

    public User(@NonNull String name, @NonNull String email, @NonNull String password, @NonNull String phoneNum, @NonNull Role role, Health health) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.role = role;
        this.health = health;
    }


    public void setHealth(Health health){
        this.health=health;
    }

}
