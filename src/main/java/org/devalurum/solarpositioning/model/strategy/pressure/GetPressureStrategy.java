package org.devalurum.solarpositioning.model.strategy.pressure;

import org.devalurum.solarpositioning.model.strategy.Answer;

public interface GetPressureStrategy<T> {

    T getPressure(Double input);

    Answer getAnswer();
}
