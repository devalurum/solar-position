package org.devalurum.solarpositioning.model.strategy.temperature.impl;

import org.devalurum.solarpositioning.model.strategy.temperature.GetTemperatureStrategy;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;

@Component
public class GetTemperatureInputStrategy implements GetTemperatureStrategy<Double> {

    @Override
    public Double getTemperature(Double in) {
        return in;
    }

    @Override
    public Answer getAnswer() {
        return Answer.UNKNOWN;
    }
}
