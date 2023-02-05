package org.vniiftri.solarpositioning.model.strategy.geolocation.impl;

import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;

import java.util.Scanner;

@Component
public class GetGeolocationUnknownStrategy implements GetGeolocationStrategy<Void> {

    @Override
    public Void getGeolocation(Scanner in) {
        System.out.println("Команда не распознана, попробуйте ещё раз.");
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.UNKNOWN;
    }
}
