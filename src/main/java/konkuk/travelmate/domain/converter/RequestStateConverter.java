package konkuk.travelmate.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import konkuk.travelmate.domain.RequestState;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@Converter(autoApply = true)
public class RequestStateConverter implements AttributeConverter<RequestState, Integer> {
    @Override
    public Integer convertToDatabaseColumn(RequestState requestState) {

        log.info("[RequestStateConverter.convertToDatabaseColumn]");

        return requestState.getValue();

    }

    @Override
    public RequestState convertToEntityAttribute(Integer dbData) {

        log.info("[RequestStateConverter.convertToEntityAttribute]");

        return Arrays.stream(RequestState.values())
                .filter(requestState -> requestState.getValue().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown database value: " + dbData));

    }
}
