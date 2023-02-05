package org.vniiftri.solarpositioning.service;

import org.vniiftri.solarpositioning.model.SpaRequest;

public interface SpaService {

    String getAzimuthZenithAngle(SpaRequest spaRequest);

}
