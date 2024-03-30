package konkuk.travelmate.service;

import konkuk.travelmate.form.response.GetVolunteerMatchingDto;
import konkuk.travelmate.repository.MatchingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchingService {

    private final MatchingRepository matchingRepository;

    public List<GetVolunteerMatchingDto> getMatchResults(String email) {
        log.info("[MatchingService.getMatchResults]");
        return matchingRepository.findVolunteerMatchingResultsByEmail(email);
    }
}
