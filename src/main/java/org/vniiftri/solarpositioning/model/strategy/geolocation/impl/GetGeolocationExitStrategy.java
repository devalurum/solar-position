package org.vniiftri.solarpositioning.model.strategy.geolocation.impl;

import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;

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
