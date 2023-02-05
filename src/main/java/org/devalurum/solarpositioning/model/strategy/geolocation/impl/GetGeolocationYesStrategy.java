package org.devalurum.solarpositioning.model.strategy.geolocation.impl;

import org.devalurum.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.Geolocation;
import org.devalurum.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

@Component
public class GetGeolocationYesStrategy implements GetGeolocationStrategy<Geolocation> {

    @Value("${app.geolocation.latitude}")
    private double latitude;
    @Value("${app.geolocation.longitude}")
    private double longitude;

    @Value("${app.geolocation.altitude}")
    private double altitude;

    @Value("${app.geolocation.side-of-the-world-azimuth}")
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
