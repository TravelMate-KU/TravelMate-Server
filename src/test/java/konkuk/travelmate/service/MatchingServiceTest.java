package konkuk.travelmate.service;

import konkuk.travelmate.config.SecurityConfig;
import konkuk.travelmate.domain.*;
import konkuk.travelmate.dto.response.GetVolunteerMatchingResponse;
import konkuk.travelmate.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.List;

import static konkuk.travelmate.domain.RequestState.*;
import static konkuk.travelmate.domain.TravelType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MatchingServiceTest {

    @Autowired private MatchingService matchingService;
    @Autowired private MatchingRepository matchingRepository;
    @Autowired private HealthRepository healthRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private CourseRepository courseRepository;
    @Autowired private RequestRepository requestRepository;
    @MockBean private SecurityConfig securityConfig;

    @AfterEach
    void tearDown() {
        matchingRepository.deleteAll();
        requestRepository.deleteAll();
        courseRepository.deleteAll();
        userRepository.deleteAll();
        healthRepository.deleteAll();
    }

    @Test
    @DisplayName("봉사자의 매칭 결과 상태로 WAIT, SUCCESS 가 조회된다.")
    void showMatchResults() {
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

        Request request = createRequest(ALL, WAIT, Timestamp.valueOf("2024-02-22 14:54:00"),
                Timestamp.valueOf("2024-02-22 14:54:00"), disabled, course);
        Request request2 = createRequest(LODGING, SUCCESS, Timestamp.valueOf("2024-02-22 14:54:00"),
                Timestamp.valueOf("2024-02-22 14:54:00"), disabled, course);
        Request request3 = createRequest(LODGING, FAIL, Timestamp.valueOf("2024-02-22 14:54:00"),
                Timestamp.valueOf("2024-02-22 14:54:00"), disabled, course);
        requestRepository.saveAll(List.of(request, request2, request3));

        Matching matching = Matching.createNullRatingMatching(volunteer, request);
        Matching matching2 = Matching.createNullRatingMatching(volunteer, request2);
        matchingRepository.saveAll(List.of(matching, matching2));

        //when
        List<GetVolunteerMatchingResponse> matchings = matchingService.getMatchResults("v1@gmail.com");

        //then
        assertThat(matchings).hasSize(2)
                .extracting("disabledName", "startTime", "endTime", "type", "state", "disabledPhoneName", "disabledEmail")
                .containsExactly(
                        tuple("d1", Timestamp.valueOf("2024-02-22 14:54:00"), Timestamp.valueOf("2024-02-22 14:54:00"),
                                ALL, WAIT, "01012341234", "d1@gmail.com"),
                        tuple("d1", Timestamp.valueOf("2024-02-22 14:54:00"), Timestamp.valueOf("2024-02-22 14:54:00"),
                                LODGING, SUCCESS, "01012341234", "d1@gmail.com")
                );
    }

    @DisplayName("봉사자의 매칭 결과 상태로 FAIL은 조회되지 않는다.")
    @Test
    void test() {
        //given
        Health health = createHealth(0, 0, 0, 0, 0, 0, 0);
        Health health2 = createHealth(0, 0, 0, 0, 0, 0, 0);
        healthRepository.saveAll(List.of(health, health2));

        User disabled = createUser("d1", "d1@gmail.com", "d1", "01012341234", Role.DISABLED, health);
        User volunteer = createUser( "v1", "v1@gmail.com", "v1", "01012341234", Role.VOLUNTEER, null);
        userRepository.saveAll(List.of(disabled, volunteer));

        Course course = createCourse("서울여행", "서울", "서울여행123", "asdf@ewaf.com", health2);
        courseRepository.save(course);

        Request request3 = createRequest(LODGING, FAIL, Timestamp.valueOf("2024-02-22 14:54:00"),
                Timestamp.valueOf("2024-02-22 14:54:00"), disabled, course);
        requestRepository.save(request3);

        Matching matching = Matching.createNullRatingMatching(volunteer, request3);
        matchingRepository.save(matching);

        //when
        List<GetVolunteerMatchingResponse> matchings = matchingService.getMatchResults("v1@gmail.com");

        //then
        assertThat(matchings).hasSize(0);
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