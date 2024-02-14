package konkuk.travelmate.controller;

import konkuk.travelmate.domain.TravelType;
import konkuk.travelmate.form.RequestForm;
import konkuk.travelmate.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
@Controller
@RequestMapping("/users/{userId}/courses/{courseId}")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping("/request")
    public String requestMatching(@PathVariable Long userId, @PathVariable Long courseId,
                                  @RequestParam TravelType type,
                                  @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                  @RequestParam("startTime") @DateTimeFormat(pattern = "HH:mm") LocalTime startTime,
                                  @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                                  @RequestParam("endTime") @DateTimeFormat(pattern = "HH:mm") LocalTime endTime) {

        log.info("[RequestController.requestMatching]");

        Timestamp startDateTime = Timestamp.valueOf(LocalDateTime.of(startDate, startTime));
        Timestamp endDateTime = Timestamp.valueOf(LocalDateTime.of(endDate, endTime));

        requestService.requestMatching(userId, courseId, new RequestForm(type, startDateTime, endDateTime));

        return "redirect:/users/{userId}/courses";

    }

}
