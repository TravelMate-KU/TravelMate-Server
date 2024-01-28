package konkuk.travelmate.domain;

import lombok.Getter;

@Getter
public enum Role {

    DISABLED(0),
    VOLUNTEER(1);

    private final Integer value;

    Role(Integer value) {
        this.value = value;
    }

}
