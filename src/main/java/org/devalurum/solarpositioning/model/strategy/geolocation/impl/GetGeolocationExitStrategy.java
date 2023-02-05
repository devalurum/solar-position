package org.devalurum.solarpositioning.model.strategy.geolocation.impl;

import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;
import org.devalurum.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;

import java.util.Scanner;

@Component
public class GetGeolocationExitStrategy implements GetGeolocationStrategy<Void> {

    @Override
    public Void getGeolocation(Scanner in) {
        System.exit(0);
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.EXIT;
    }
}
