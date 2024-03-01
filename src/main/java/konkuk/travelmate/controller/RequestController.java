package konkuk.travelmate.controller;

import konkuk.travelmate.domain.TravelType;
import konkuk.travelmate.form.request.RequestsRequest;
import konkuk.travelmate.form.response.RequestsResponse;
import konkuk.travelmate.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping("/users/{userId}/courses/{courseId}/request")
    public String requestMatching(@PathVariable Long userId, @PathVariable Long courseId,
                                  @RequestParam TravelType type,
                                  @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                  @RequestParam("startTime") @DateTimeFormat(pattern = "HH:mm") LocalTime startTime,
                                  @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                                  @RequestParam("endTime") @DateTimeFormat(pattern = "HH:mm") LocalTime endTime) {

        log.info("[RequestController.requestMatching]");

        Timestamp startDateTime = Timestamp.valueOf(LocalDateTime.of(startDate, startTime));
        Timestamp endDateTime = Timestamp.valueOf(LocalDateTime.of(endDate, endTime));

        requestService.requestMatching(userId, courseId, new RequestsRequest(type, startDateTime, endDateTime));

        return "redirect:/users/{userId}/courses";

    }

    /**
     * 봉사자 -> 장애인 조회
     */
    @GetMapping("/requests")
    public String showRequests(@RequestParam(value = "walk", required = false) Integer walk,
                               @RequestParam(value = "see", required = false) Integer see,
                               @RequestParam(value = "talk", required = false) Integer talk,
                               @RequestParam(value = "listen", required = false) Integer listen,
                               @RequestParam(value = "iq", required = false) Integer iq,
                               @RequestParam(value = "depression", required = false) Integer depression,
                               @RequestParam(value = "bipolar_disorder", required = false) Integer bipolarDisorder,
                               Model model) {

        log.info("[RequestController.showRequests]");

        List<RequestsResponse> requestsResponses = new ArrayList<>();
        
        if(isSearchButtonClicked(walk, see, talk, listen, iq, depression, bipolarDisorder)) {
            requestsResponses = requestService.showRequests(walk, see, talk, listen, iq, depression, bipolarDisorder);
        }

        model.addAttribute("requests", requestsResponses);

        return "volunteer_matching";
    }

    private boolean isSearchButtonClicked(Integer walk, Integer see, Integer talk, Integer listen, Integer iq, Integer depression, Integer bipolarDisorder) {
        return walk != null && see != null && talk != null && listen != null && iq != null && depression != null && bipolarDisorder != null;
    }

}
