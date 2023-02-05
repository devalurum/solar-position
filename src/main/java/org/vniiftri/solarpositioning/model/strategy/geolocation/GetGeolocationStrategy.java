package org.vniiftri.solarpositioning.model.strategy.geolocation;

import org.vniiftri.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

public interface GetGeolocationStrategy<T> {

    T getGeolocation(Scanner in);

    Answer getAnswer();
}
