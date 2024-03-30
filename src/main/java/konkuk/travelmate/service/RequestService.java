package konkuk.travelmate.service;

import konkuk.travelmate.domain.*;
import konkuk.travelmate.form.request.RequestsRequest;
import konkuk.travelmate.form.response.RequestsResponse;
import konkuk.travelmate.repository.CourseRepository;
import konkuk.travelmate.repository.MatchingRepository;
import konkuk.travelmate.repository.RequestRepository;
import konkuk.travelmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final MatchingRepository matchingRepository;

    public void requestMatching(Long disabledId, Long courseId, RequestsRequest requestForm) {

        log.info("[RequestService.requestMatching]");

        User disabled = userRepository.findById(disabledId).orElseThrow(() -> new RuntimeException("user not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("course not found"));
        Request request = requestForm.toEntity(disabled, course);

        requestRepository.save(request);
    }

    public List<RequestsResponse> showRequests(int walk, int see, int talk, int listen, int iq, int depression, int bipolarDisorder) {
        log.info("[RequestService.showRequests]");
        return requestRepository.findRequestsByStateAndHealthLevel(walk, see, talk, listen, iq, depression, bipolarDisorder);
    }

    @Transactional
    public void acceptDisabledRequest(Long requestId, String volunteerEmail) {
        log.info("[RequestService.acceptDisabledRequest]");

        Request request = requestRepository.findById(requestId).orElseThrow(() -> new RuntimeException("request not found"));
        request.changeStateToWait();

        User user = userRepository.findByEmail(volunteerEmail).orElseThrow(() -> new RuntimeException("user not found"));
        Matching matching = Matching.createNullRatingMatching(user, request);

        matchingRepository.save(matching);
    }

}
