package konkuk.travelmate.domain;

import lombok.Getter;

@Getter
public enum TravelType {
    ALL(1),
    TRANSPORTATION(2),
    LODGING(3),
    RESTAURANT(4),
    PLACE(5);

    private final Integer value;

    TravelType(Integer value) {
        this.value = value;
    }

}
