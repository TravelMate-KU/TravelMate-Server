package konkuk.travelmate.config;

import konkuk.travelmate.security.GoogleOAuthProperties;
import konkuk.travelmate.security.OAuth2MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final OAuth2MemberService oAuth2MemberService;

    public SecurityConfig(OAuth2MemberService oAuth2MemberService) {
        this.oAuth2MemberService = oAuth2MemberService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(CsrfConfigurer::disable)
                .oauth2Login(o -> o
                        .loginPage("/login/")
                        .defaultSuccessUrl("/login/gateway")
                        .userInfoEndpoint(info -> info
                                .userService(oAuth2MemberService)
                        )//로그인 완료 후 회원 정보 받기
                        .clientRegistrationRepository(clientRegistrationRepository())

                )


                .authorizeHttpRequests(o->o
                        .requestMatchers("/test").authenticated()
                        .anyRequest().permitAll()
                )
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
                .scope("email","profile")
                .build();
    }



    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration clientRegistration = googleOauthClientRegistration();
        return new InMemoryClientRegistrationRepository(clientRegistration);

    }

}
