package org.vniiftri.solarpositioning.service.impl;

import lombok.RequiredArgsConstructor;
import net.e175.klaus.solarpositioning.AzimuthZenithAngle;
import net.e175.klaus.solarpositioning.SPA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.vniiftri.solarpositioning.event.SpaEvent;
import org.vniiftri.solarpositioning.model.Geolocation;
import org.vniiftri.solarpositioning.model.SpaAnswer;
import org.vniiftri.solarpositioning.model.SpaRequest;
import org.vniiftri.solarpositioning.service.SpaService;

@Service
@RequiredArgsConstructor
public class SpaServiceImpl implements SpaService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String getAzimuthZenithAngle(SpaRequest spaRequest) {
        Geolocation geolocation = spaRequest.getGeolocation();

        AzimuthZenithAngle azimuthZenithAngle = SPA.calculateSolarPosition(spaRequest.getDateTime(),
                geolocation.getLatitude(),
                geolocation.getLongitude(),
                geolocation.getAltitude(),
                spaRequest.getDeltaT(),
                spaRequest.getPressure(),
                spaRequest.getTemperature());

        SpaAnswer spaAnswer = SpaAnswer.builder()
                .spaRequest(spaRequest)
                .azimuthZenithAngle(azimuthZenithAngle)
                .build();

        applicationEventPublisher.publishEvent(new SpaEvent(spaAnswer));

        return String.format("Азимут:\n%s\nУгол места:\n%s",
                azimuthZenithAngle.getAzimuth(),
                geolocation.getPlaneAzimuth() - azimuthZenithAngle.getZenithAngle());
    }
}
