package konkuk.travelmate.dto.request;


public record GetRequestsRequest(Integer walk, Integer see, Integer talk, Integer listen, Integer iq, Integer depression, Integer bipolarDisorder) {

    public boolean isNotNull() {
        return walk != null && see != null && talk != null && listen != null && iq != null && depression != null && bipolarDisorder != null;
    }
}
