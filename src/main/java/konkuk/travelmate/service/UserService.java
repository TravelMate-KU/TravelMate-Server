package konkuk.travelmate.service;

import konkuk.travelmate.domain.Health;
import konkuk.travelmate.domain.Role;
import konkuk.travelmate.domain.User;
import konkuk.travelmate.repository.HealthRepository;
import konkuk.travelmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    public final HealthRepository healthRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Transactional
    public User joinDisable(OAuth2User oAuth2User, Map<String, String> signupMap, Role role) {
        Health health = new Health(Integer.parseInt(signupMap.get("see")), Integer.parseInt(signupMap.get("walk")),
                Integer.parseInt(signupMap.get("talk")), Integer.parseInt(signupMap.get("listen")), Integer.parseInt(signupMap.get("iq")),
                Integer.parseInt(signupMap.get("bipolar_disorder")), Integer.parseInt(signupMap.get("depression")));
        User user = new User(Objects.requireNonNull(oAuth2User.getAttribute("name")), Objects.requireNonNull(oAuth2User.getAttribute("email")), UUID.randomUUID().toString(), signupMap.get("phoneNum"), role, health);
        healthRepository.save(health);
        userRepository.save(user);
        return user;
    }

    public User joinVolunteer(OAuth2User oAuth2User, Map<String, String> signupMap, Role role) {
        Health health = Health.getDummyHealth();
        User user = new User(Objects.requireNonNull(oAuth2User.getAttribute("name")), Objects.requireNonNull(oAuth2User.getAttribute("email")), UUID.randomUUID().toString(), signupMap.get("phoneNum"), role, health);
        healthRepository.save(health);
        userRepository.save(user);
        return user;
    }

}
