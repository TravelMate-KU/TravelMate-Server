package konkuk.travelmate.repository;

import konkuk.travelmate.domain.*;
import konkuk.travelmate.dto.response.GetVolunteerMatchingResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@RepositoryTest
class MatchingRepositoryTest {

    @Autowired MatchingRepository matchingRepository;
    @Autowired HealthRepository healthRepository;
    @Autowired UserRepository userRepository;
    @Autowired CourseRepository courseRepository;
    @Autowired RequestRepository requestRepository;

    @Test
    @DisplayName("해당 봉사자와 연관된 매칭들을 모두 조회한다.")
    void findVolunteerMatchingResultsByEmail() {

        //given
        Health health = createHealth(0, 0, 0, 0, 0, 0, 0);
        Health health2 = createHealth(0, 0, 0, 0, 0, 0, 0);
        Health health3 = createHealth(0, 0, 0, 0, 0, 0, 0);
        healthRepository.saveAll(List.of(health, health2, health3));

        User disabled = createUser("d1", "d1@gmail.com", "d1", "01012341234", Role.DISABLED, health);
        User volunteer = createUser( "v1", "v1@gmail.com", "v1", "01012341234", Role.VOLUNTEER, null);
        userRepository.saveAll(List.of(disabled, volunteer));

        Course course = createCourse("서울여행", "서울", "서울여행123", "asdf@ewaf.com", health2);
        Course course2 = createCourse("부산여행", "부산", "부산여행123", "asdf@ewaf.com", health3);
        courseRepository.saveAll(List.of(course, course2));

        Request request = createRequest(TravelType.ALL, RequestState.WAIT, Timestamp.valueOf("2024-02-22 14:54:00"),
                Timestamp.valueOf("2024-02-22 14:54:00"), disabled, course);
        Request request2 = createRequest(TravelType.LODGING, RequestState.SUCCESS, Timestamp.valueOf("2024-02-22 14:54:00"),
                Timestamp.valueOf("2024-02-22 14:54:00"), disabled, course);
        requestRepository.saveAll(List.of(request, request2));

        Matching matching = Matching.createNullRatingMatching(volunteer, request);
        Matching matching2 = Matching.createNullRatingMatching(volunteer, request2);
        matchingRepository.saveAll(List.of(matching, matching2));

        String email = volunteer.getEmail();

        //when
        List<GetVolunteerMatchingResponse> matchings = matchingRepository.findVolunteerMatchingResultsByEmail(email);

        //then
        assertThat(matchings).hasSize(2)
                .extracting("disabledName", "startTime", "endTime", "type", "state", "disabledPhoneName", "disabledEmail")
                .containsExactly(
                        tuple("d1", Timestamp.valueOf("2024-02-22 14:54:00"), Timestamp.valueOf("2024-02-22 14:54:00"),
                                TravelType.ALL, RequestState.WAIT, "01012341234", "d1@gmail.com"),
                        tuple("d1", Timestamp.valueOf("2024-02-22 14:54:00"), Timestamp.valueOf("2024-02-22 14:54:00"),
                                TravelType.LODGING, RequestState.SUCCESS, "01012341234", "d1@gmail.com")
                );
    }

    private Health createHealth(int walk, int see, int talk, int listen, int depression, int bipolarDisorder, int iq) {
        return Health.builder()
                .walk(walk)
                .see(see)
                .talk(talk)
                .listen(listen)
                .depression(depression)
                .bipolarDisorder(bipolarDisorder)
                .iq(iq)
                .build();
    }

    private User createUser(String name, String email, String password, String phoneNum, Role role, Health health) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phoneNum(phoneNum)
                .role(role)
                .health(health)
                .build();
    }

    private Course createCourse(String name, String description, String region, String imageUrl, Health health) {
        return Course.builder()
                .name(name)
                .description(description)
                .region(region)
                .imageUrl(imageUrl)
                .health(health)
                .build();
    }

    private Request createRequest(TravelType type, RequestState state, Timestamp startTime, Timestamp endTime, User disabled, Course course) {
        return Request.builder()
                .type(type)
                .state(state)
                .startTime(startTime)
                .endTime(endTime)
                .disabled(disabled)
                .course(course)
                .build();
    }
}