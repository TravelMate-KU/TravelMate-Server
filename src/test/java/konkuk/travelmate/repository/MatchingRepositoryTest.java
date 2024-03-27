package konkuk.travelmate.repository;

import konkuk.travelmate.domain.*;
import konkuk.travelmate.form.response.VolunteerMatchingResponse;
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
        Health health = new Health(1L, 0, 0, 0, 0, 0, 0, 0);
        healthRepository.save(health);
        User disabled = new User(1L, "d1", "d1@gmail.com", "d1", "01012341234", Role.DISABLED, health);
        userRepository.save(disabled);

        Health health2 = new Health(2L, 0, 0, 0, 0, 0, 0, 0);
        healthRepository.save(health2);
        Course course = new Course(1L, "서울여행", "서울", "서울여행123", "asdf@ewaf.com", health2);
        courseRepository.save(course);

        Health health3 = new Health(3L, 0, 0, 0, 0, 0, 0, 0);
        healthRepository.save(health3);
        Course course2 = new Course(2L, "부산여행", "부산", "부산여행123", "asdf@ewaf.com", health3);
        courseRepository.save(course2);


        User volunteer = new User(2L, "v1", "v1@gmail.com", "v1", "01012341234", Role.VOLUNTEER, null);
        userRepository.save(volunteer);

        Request request = new Request(1L, TravelType.ALL, RequestState.WAIT, Timestamp.valueOf("2024-02-22 14:54:00"),
                Timestamp.valueOf("2024-02-22 14:54:00"), disabled, course);
        requestRepository.save(request);

        Request request2 = new Request(2L, TravelType.LODGING, RequestState.SUCCESS, Timestamp.valueOf("2024-02-22 14:54:00"),
                Timestamp.valueOf("2024-02-22 14:54:00"), disabled, course);
        requestRepository.save(request2);

        Matching matching = new Matching(1L, 0, volunteer, request);
        matchingRepository.save(matching);

        Matching matching2 = new Matching(2L, 0, volunteer, request2);
        matchingRepository.save(matching2);

        String email = volunteer.getEmail();

        //when
        List<VolunteerMatchingResponse> matchings = matchingRepository.findVolunteerMatchingResultsByEmail(email);

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
}