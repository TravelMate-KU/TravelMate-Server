package konkuk.travelmate.controller;

import konkuk.travelmate.dto.response.GetVolunteerMatchingResponse;
import konkuk.travelmate.service.MatchingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/matchings")
@RequiredArgsConstructor
public class MatchingController {

    private final MatchingService matchingService;

    @GetMapping
    private String showMatchResults(@AuthenticationPrincipal OAuth2User user, Model model) {

        log.info("[MatchingController.showMatchResults]");
        String email = Objects.requireNonNull(user.getAttribute("email")).toString();
        List<GetVolunteerMatchingResponse> matchings = matchingService.getMatchResults(email);
        model.addAttribute("matchings", matchings);

        return "volunteer_matching_result";
    }


}
