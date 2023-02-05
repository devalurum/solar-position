package org.devalurum.solarpositioning.model.strategy.geolocation;

import org.devalurum.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

public interface GetGeolocationStrategy<T> {

    T getGeolocation(Scanner in);

    Answer getAnswer();
}
