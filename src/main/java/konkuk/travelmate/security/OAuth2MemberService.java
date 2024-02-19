package konkuk.travelmate.security;

import konkuk.travelmate.domain.Health;
import konkuk.travelmate.domain.User;
import konkuk.travelmate.repository.HealthRepository;
import konkuk.travelmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OAuth2MemberService extends DefaultOAuth2UserService {

    public final UserRepository userRepository;
    @Override
    @Transactional(readOnly = false)
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("oAuth2User = " + oAuth2User.getAttributes());
        String email=oAuth2User.getAttribute("email");


        return super.loadUser(userRequest);
    }

}