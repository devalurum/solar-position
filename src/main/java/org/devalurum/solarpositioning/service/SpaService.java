package org.devalurum.solarpositioning.service;

import org.devalurum.solarpositioning.model.SpaRequest;

public interface SpaService {

    String getAzimuthZenithAngle(SpaRequest spaRequest);

}
