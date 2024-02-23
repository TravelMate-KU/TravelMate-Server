package konkuk.travelmate.service;

import konkuk.travelmate.domain.Course;
import konkuk.travelmate.domain.Request;
import konkuk.travelmate.domain.RequestState;
import konkuk.travelmate.domain.User;
import konkuk.travelmate.form.request.RequestsRequest;
import konkuk.travelmate.form.response.RequestsResponse;
import konkuk.travelmate.repository.CourseRepository;
import konkuk.travelmate.repository.RequestRepository;
import konkuk.travelmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public void requestMatching(Long disabledId, Long courseId, RequestsRequest requestForm) {

        log.info("[RequestService.requestMatching]");

        User disabled = userRepository.findById(disabledId).orElseThrow(() -> new RuntimeException("user not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("course not found"));

        requestRepository.save(
                new Request(
                        requestForm.getType(),
                        RequestState.PENDING,
                        requestForm.getStartTime(),
                        requestForm.getEndTime(),
                        disabled,
                        course));

    }

    public List<RequestsResponse> showRequests(int walk, int see, int talk, int listen, int iq, int depression, int bipolarDisorder) {

        log.info("[RequestService.showRequests]");

        return requestRepository.findRequestsByStateAndHealthLevel(walk, see, talk, listen, iq, depression, bipolarDisorder);

    }
}
