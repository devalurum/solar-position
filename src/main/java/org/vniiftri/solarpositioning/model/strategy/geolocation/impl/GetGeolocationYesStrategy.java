package org.vniiftri.solarpositioning.model.strategy.geolocation.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.Geolocation;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Scanner;

@Component
public class GetGeolocationYesStrategy implements GetGeolocationStrategy<Geolocation> {

    @Value("${vniiftri.geolocation.latitude}")
    private double latitude;
    @Value("${vniiftri.geolocation.longitude}")
    private double longitude;

    @Value("${vniiftri.geolocation.altitude}")
    private double altitude;

    @Value("${vniiftri.geolocation.side-of-the-world-azimuth}")
    private double planeAzimuth;

    @Override
    public Geolocation getGeolocation(Scanner in) {
        return Geolocation.builder()
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .planeAzimuth(planeAzimuth)
                .build();
    }

    @Override
    public Answer getAnswer() {
        return Answer.YES;
    }
}
