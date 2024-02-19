package konkuk.travelmate.controller;

import konkuk.travelmate.domain.Health;
import konkuk.travelmate.domain.Role;
import konkuk.travelmate.domain.TravelType;
import konkuk.travelmate.domain.User;
import konkuk.travelmate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public String loginView() {
        return "/login";
    }

    @GetMapping("/gateway")
    public String gateway(@AuthenticationPrincipal OAuth2User oauth) {
        Optional<User> user = userService.findByEmail(oauth.getAttribute("email"));
        if (user.isEmpty()) {
            return "redirect:select";
        } else if (user.get().getRole() == Role.DISABLED) {
            return "disable";
        } else if (user.get().getRole() == Role.VOLUNTEER) {
            return "volunteer";
        }
        return "/error";
    }
    @GetMapping("/select")
    public String selectView(){
        return "/login_signup_select";
    }

    @GetMapping("/signup/disable")
    public String signupDisableView(@AuthenticationPrincipal OAuth2User oAuth2User, Model model) {
        model.addAttribute("name",oAuth2User.getAttribute("name"));
        model.addAttribute("email",oAuth2User.getAttribute("email"));
        return "/login_signup_unwell";
    }

    @PostMapping("/signup/disable")
    public String signupDisable(@AuthenticationPrincipal OAuth2User oAuth2User,@RequestBody Map<String, String> signupMap){
        userService.joinDisable(oAuth2User,signupMap, Role.DISABLED);
        return "sucess";
    }

    @GetMapping("/signup/volunteer")
    public String signupVolunteerView(@AuthenticationPrincipal OAuth2User oAuth2User, Model model) {
        model.addAttribute("name",oAuth2User.getAttribute("name"));
        model.addAttribute("email",oAuth2User.getAttribute("email"));
        return "/login_signup_volunteer";
    }

    @PostMapping("/signup/volunteer")
    public String signupVolunteer(@AuthenticationPrincipal OAuth2User oAuth2User,@RequestBody Map<String, String> signupMap){
        userService.joinVolunteer(oAuth2User,signupMap, Role.VOLUNTEER);
        return "sucess";
    }


}
