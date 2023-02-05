package org.vniiftri.solarpositioning.model.strategy.temperature.impl;

import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.temperature.GetTemperatureStrategy;

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
