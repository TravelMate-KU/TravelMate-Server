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

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository UserRepository;
    public final HealthRepository healthRepository;

    public Optional<User> findByEmail(String email) {
        return UserRepository.findByEmail(email);
    }


    public User joinDisable(OAuth2User OAuth2User, Map<String, String> signupMap, Role role) {
        Health health = new Health(Integer.parseInt(signupMap.get("see")), Integer.parseInt(signupMap.get("walk")),
                Integer.parseInt(signupMap.get("talk")), Integer.parseInt(signupMap.get("listen")), Integer.parseInt(signupMap.get("iq")),
                Integer.parseInt(signupMap.get("bipolar_disorder")), Integer.parseInt(signupMap.get("depression")));
        User User = new User(Objects.requireNonNull(OAuth2User.getAttribute("name")), Objects.requireNonNull(OAuth2User.getAttribute("email")), UUID.randomUUID().toString(), signupMap.get("phoneNum"), role, health);
        healthRepository.save(health);
        UserRepository.save(User);
        return User;
    }

    public User joinVolunteer(OAuth2User OAuth2User, Map<String, String> signupMap, Role role) {
        User User = new User(Objects.requireNonNull(OAuth2User.getAttribute("name")), Objects.requireNonNull(OAuth2User.getAttribute("email")), UUID.randomUUID().toString(), signupMap.get("phoneNum"), role, null);
        UserRepository.save(User);
        return User;
    }

}
