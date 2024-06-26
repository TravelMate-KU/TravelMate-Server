package konkuk.travelmate.service;

import konkuk.travelmate.domain.Health;
import konkuk.travelmate.domain.Role;
import konkuk.travelmate.domain.User;
import konkuk.travelmate.repository.HealthRepository;
import konkuk.travelmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.lang.Integer.*;
import static java.util.Objects.*;
import static java.util.UUID.*;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository UserRepository;
    public final HealthRepository healthRepository;

    public Optional<User> findByEmail(String email) {
        return UserRepository.findByEmail(email);
    }


    public User joinDisable(OAuth2User OAuth2User, Map<String, String> signupMap, Role role) {
        Health health = Health.of(signupMap);
        User user = buildUser(OAuth2User, signupMap, role, health);
        healthRepository.save(health);
        UserRepository.save(user);
        return user;
    }

    public User joinVolunteer(OAuth2User OAuth2User, Map<String, String> signupMap, Role role) {
        User user = buildUser(OAuth2User, signupMap, role, null);
        UserRepository.save(user);
        return user;
    }

    private User buildUser(OAuth2User OAuth2User, Map<String, String> signupMap, Role role, Health health) {
        return User.builder()
                .name(requireNonNull(OAuth2User.getAttribute("name")).toString())
                .email(requireNonNull(OAuth2User.getAttribute("email")).toString())
                .password(randomUUID().toString())
                .phoneNum(signupMap.get("phoneNum"))
                .role(role)
                .health(health)
                .build();
    }

}