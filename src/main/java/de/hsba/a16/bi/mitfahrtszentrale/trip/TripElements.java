package de.hsba.a16.bi.mitfahrtszentrale.trip;

import javax.validation.constraints.NotNull;

public class TripElements {
    @NotNull(message = "please do not leave it empty")
    private String tripStart;
    @NotNull(message = "please do not leave it empty")
    private String tripEnd;
    @NotNull(message = "please do not leave it empty")
    private String tripDescription;

    public TripElements(String tripStart, String tripEnd, String tripDescription) {
        this.tripStart = tripStart;
        this.tripEnd = tripEnd;
        this.tripDescription = tripDescription;
    }

    public String getTripStart() {
        return tripStart;
    }

    public void setTripStart(String tripStart) {
        this.tripStart = tripStart;
    }

    public String getTripEnd() {
        return tripEnd;
    }

    public void setTripEnd(String tripEnd) {
        this.tripEnd = tripEnd;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }
}
