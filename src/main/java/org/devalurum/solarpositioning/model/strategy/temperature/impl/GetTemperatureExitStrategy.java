package org.devalurum.solarpositioning.model.strategy.temperature.impl;

import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;
import org.devalurum.solarpositioning.model.strategy.temperature.GetTemperatureStrategy;

@Component
public class GetTemperatureExitStrategy implements GetTemperatureStrategy<Void> {

    @Override
    public Void getTemperature(Double in) {
        System.exit(0);
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.EXIT;
    }
}
