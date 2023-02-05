package org.vniiftri.solarpositioning.model.strategy.pressure.impl;

import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;
import org.vniiftri.solarpositioning.model.strategy.pressure.GetPressureStrategy;

import java.util.Scanner;

@Component
public class GetPressureExitStrategy implements GetPressureStrategy<Void> {

    @Override
    public Void getPressure(Double in) {
        System.exit(0);
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.EXIT;
    }
}
