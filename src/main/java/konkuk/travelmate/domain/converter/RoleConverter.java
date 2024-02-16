package konkuk.travelmate.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import konkuk.travelmate.domain.Role;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Role role) {

        log.info("[RoleConverter.convertToDatabaseColumn, role = {}]", role);

        return role.getValue();

    }

    @Override
    public Role convertToEntityAttribute(Integer dbData) {

        log.info("[RoleConverter.convertToEntityAttribute, dbData = {}]", dbData);

        return Arrays.stream(Role.values())
                .filter(role -> role.getValue().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown database value: " + dbData));

    }
}
