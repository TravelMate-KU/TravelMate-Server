package konkuk.travelmate.controller;

import konkuk.travelmate.dto.request.GetRequestsRequest;
import konkuk.travelmate.dto.request.PostRequestRequest;
import konkuk.travelmate.dto.response.GetRequestsResponse;
import konkuk.travelmate.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping("/users/{userId}/courses/{courseId}/request")
    public String requestMatching(@PathVariable Long userId, @PathVariable Long courseId, PostRequestRequest request) {

        log.info("[RequestController.requestMatching]");

        requestService.requestMatching(userId, courseId, request);

        return "redirect:/users/{userId}/courses";

    }

    /**
     * 봉사자 -> 장애인 조회
     */
    @GetMapping("/requests")
    public String showRequests(GetRequestsRequest request, Model model) {

        log.info("[RequestController.showRequests]");

        List<GetRequestsResponse> getRequestsResponses = new ArrayList<>();
        
        if(request.isNotNull()) {
            getRequestsResponses = requestService.showRequests(request);
        }

        model.addAttribute("requests", getRequestsResponses);

        return "volunteer_matching";
    }

    /**
     * 봉사자 -> 장애인 요청 수락
     * 매칭 생성
     */
    @PostMapping("/requests/{requestId}/matchings")
    public String acceptDisabledRequest(@PathVariable Long requestId, @AuthenticationPrincipal OAuth2User user) {

        log.info("[RequestController.acceptDisabledRequest]");

        String email = Objects.requireNonNull(user.getAttribute("email")).toString();

        requestService.acceptDisabledRequest(requestId, email);

        return "redirect:/matchings";
    }

}
