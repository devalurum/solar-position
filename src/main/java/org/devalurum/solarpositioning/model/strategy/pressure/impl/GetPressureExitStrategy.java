package org.devalurum.solarpositioning.model.strategy.pressure.impl;

import org.devalurum.solarpositioning.model.strategy.pressure.GetPressureStrategy;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;

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
