package konkuk.travelmate.service;

import konkuk.travelmate.dto.response.GetVolunteerMatchingResponse;
import konkuk.travelmate.repository.MatchingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MatchingService {

    private final MatchingRepository matchingRepository;

    public List<GetVolunteerMatchingResponse> getMatchResults(String email) {
        log.info("[MatchingService.getMatchResults]");
        return matchingRepository.findVolunteerMatchingResultsByEmail(email);
    }
}
