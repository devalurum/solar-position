package org.vniiftri.solarpositioning.model.strategy.temperature;

import org.vniiftri.solarpositioning.model.strategy.Answer;

public interface GetTemperatureStrategy<T> {

    T getTemperature(Double input);

    Answer getAnswer();
}
