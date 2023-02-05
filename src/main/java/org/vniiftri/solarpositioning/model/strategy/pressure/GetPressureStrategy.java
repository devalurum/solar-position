package org.vniiftri.solarpositioning.model.strategy.pressure;

import org.vniiftri.solarpositioning.model.strategy.Answer;

public interface GetPressureStrategy<T> {

    T getPressure(Double input);

    Answer getAnswer();
}
