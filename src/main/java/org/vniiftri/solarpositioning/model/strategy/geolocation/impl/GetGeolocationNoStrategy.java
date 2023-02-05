package org.vniiftri.solarpositioning.model.strategy.geolocation.impl;

import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.Geolocation;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;

import java.util.Scanner;

@Component
public class GetGeolocationNoStrategy implements GetGeolocationStrategy<Geolocation> {

    @Override
    public Geolocation getGeolocation(Scanner in) {
        try {
            System.out.println("Введите широту: ");
            String latitudeStr = in.nextLine();
            double latitude = Double.parseDouble(latitudeStr);

            System.out.println("Введите долготу: ");
            String longitudeStr = in.nextLine();
            double longitude = Double.parseDouble(longitudeStr);

            System.out.println("Введите высоту над уровнем моря: ");
            String altitudeStr = in.nextLine();
            double altitude = Double.parseDouble(altitudeStr);

            System.out.println("Введите эталонную плоскостью для азимута " +
                    "\n(Восток - 90°, Юг - 180°, Запад - 270°, Север - 360°): ");
            String planeAzimuthStr = in.nextLine();
            double planeAzimuth = Double.parseDouble(planeAzimuthStr);

            return Geolocation.builder()
                    .latitude(latitude)
                    .longitude(longitude)
                    .altitude(altitude)
                    .planeAzimuth(planeAzimuth)
                    .build();
        } catch (Exception ex) {
            System.out.println("Не удалось распознать долготу, широту или высоту, попробуйте ещё раз.");
            return this.getGeolocation(in);
        }
    }

    @Override
    public Answer getAnswer() {
        return Answer.NO;
    }
}
