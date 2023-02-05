package org.devalurum.solarpositioning.model.strategy.temperature;

import org.devalurum.solarpositioning.model.strategy.Answer;

public interface GetTemperatureStrategy<T> {

    T getTemperature(Double input);

    Answer getAnswer();
}
