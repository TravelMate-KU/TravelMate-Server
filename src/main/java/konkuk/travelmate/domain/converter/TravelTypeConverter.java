package konkuk.travelmate.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import konkuk.travelmate.domain.TravelType;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@Converter(autoApply = true)
public class TravelTypeConverter implements AttributeConverter<TravelType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TravelType travelType) {

        log.info("[TravelTypeConverter.convertToDatabaseColumn]");

        return travelType.getValue();

    }

    @Override
    public TravelType convertToEntityAttribute(Integer dbData) {

        log.info("[TravelTypeConverter.convertToEntityAttribute]");

        return Arrays.stream(TravelType.values())
                .filter(travelType -> travelType.getValue().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown database value: " + dbData));

    }

}
