package org.devalurum.solarpositioning.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Geolocation {
    double latitude;
    double longitude;
    double altitude;
    double planeAzimuth;
}
