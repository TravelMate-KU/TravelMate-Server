package konkuk.travelmate.service;

import konkuk.travelmate.domain.Course;
import konkuk.travelmate.domain.Request;
import konkuk.travelmate.domain.RequestState;
import konkuk.travelmate.domain.User;
import konkuk.travelmate.form.RequestForm;
import konkuk.travelmate.repository.CourseRepository;
import konkuk.travelmate.repository.RequestRepository;
import konkuk.travelmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public void requestMatching(Long disabledId, Long courseId, RequestForm requestForm) {

        log.info("RequestService.requestMatching");

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
}
