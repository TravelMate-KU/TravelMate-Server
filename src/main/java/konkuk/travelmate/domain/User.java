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

    private String name;

    private String email;

    private String password;

    private String phoneNum;

    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "h_id")
    private Health health;

    @Builder
    private User(String name, String email, String password, String phoneNum, Role role, Health health) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.role = role;
        this.health = health;
    }

    public static User of(String name, String email, String string, String phoneNum, Role role, Health health) {
        return User.builder()
                .name(name)
                .email(email)
                .password(builder().password)
                .phoneNum(phoneNum)
                .role(role)
                .health(health)
                .build();
    }


    public void setHealth(Health health){
        this.health=health;
    }

}
