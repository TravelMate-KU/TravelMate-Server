package konkuk.travelmate.config;

import konkuk.travelmate.security.GoogleOAuthProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .oauth2Login(o -> o
                        .clientRegistrationRepository(clientRegistrationRepository())
                )


                .authorizeHttpRequests(o->
                        o.anyRequest().authenticated())
                ;
        return http.build();
    }

    @Bean
    public GoogleOAuthProperties googleOAuthProperties(){
        return new GoogleOAuthProperties();
    }
    private ClientRegistration googleOauthClientRegistration() {


        return CommonOAuth2Provider.GOOGLE
                .getBuilder("google")
                .clientId(googleOAuthProperties().getClientId())
                .clientSecret(googleOAuthProperties().getClientSecret())
                .build();
    }



    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration clientRegistration = googleOauthClientRegistration();
        return new InMemoryClientRegistrationRepository(clientRegistration);

    }

}
