package konkuk.travelmate.domain;

import lombok.Getter;

@Getter
public enum RequestState {

    WAIT(1),
    FAIL(2),
    SUCCESS(3),
    PENDING(4);

    private final Integer value;

    RequestState(Integer value) {
        this.value = value;
    }

}
