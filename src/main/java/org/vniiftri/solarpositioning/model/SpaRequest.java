package org.vniiftri.solarpositioning.model;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Value
@Builder
public class SpaRequest {
    @NotNull
    ZonedDateTime dateTime;

    @NotNull
    Geolocation geolocation;

    double deltaT;
    double pressure;
    double temperature;
}
