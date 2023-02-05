package org.devalurum.solarpositioning.model;

import lombok.Builder;
import lombok.Value;
import net.e175.klaus.solarpositioning.AzimuthZenithAngle;
import org.devalurum.solarpositioning.utils.Utils;

@Value
@Builder
public class SpaAnswer {
    SpaRequest spaRequest;
    AzimuthZenithAngle azimuthZenithAngle;

    @Override
    public String toString() {
        return "Дата:\n" + spaRequest.getDateTime().format(Utils.ZONED_DATE_TIME_FORMATTER) + "\n" +
                "Широта:\n" + spaRequest.getGeolocation().getLatitude() + "\n" +
                "Долгота:\n" + spaRequest.getGeolocation().getLongitude() + "\n" +
                "Высота:\n" + spaRequest.getGeolocation().getAltitude() + "\n" +
                "Азимут:\n" + azimuthZenithAngle.getAzimuth() + "\n" +
                "Угол места:\n" + (spaRequest.getGeolocation().getPlaneAzimuth() - azimuthZenithAngle.getZenithAngle());
    }
}
