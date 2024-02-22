package konkuk.travelmate.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.google")
@RequiredArgsConstructor
@Getter
public class GoogleOAuthProperties {
    private final String clientId;
    private final String clientSecret;

    // getters and setters
}
