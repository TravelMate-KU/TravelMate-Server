package konkuk.travelmate.service;

import konkuk.travelmate.domain.*;
import konkuk.travelmate.dto.request.GetRequestsRequest;
import konkuk.travelmate.dto.request.PostRequestRequest;
import konkuk.travelmate.dto.response.GetRequestsResponse;
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

    public void requestMatching(Long disabledId, Long courseId, PostRequestRequest requestForm) {

        log.info("[RequestService.requestMatching]");

        User disabled = userRepository.findById(disabledId).orElseThrow(() -> new RuntimeException("user not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("course not found"));
        Request request = requestForm.toEntity(disabled, course);

        requestRepository.save(request);
    }

    @Transactional(readOnly = true)
    public List<GetRequestsResponse> showRequests(GetRequestsRequest request) {
        log.info("[RequestService.showRequests]");
        return requestRepository.findRequestsByStateAndHealthLevel(
                request.walk(), request.see(), request.talk(), request.listen(), request.iq(), request.depression(), request.bipolarDisorder()
        );
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
