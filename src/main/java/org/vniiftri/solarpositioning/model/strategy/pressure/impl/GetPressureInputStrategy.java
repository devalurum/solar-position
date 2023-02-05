package org.vniiftri.solarpositioning.model.strategy.pressure.impl;

import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.pressure.GetPressureStrategy;

@Component
public class GetPressureInputStrategy implements GetPressureStrategy<Double> {


    private static final double HECTO_PASCAL_MULTIPLIER = 1.333_223_874_15;

    @Override
    public Double getPressure(Double in) {
        return in * HECTO_PASCAL_MULTIPLIER;
    }

    @Override
    public Answer getAnswer() {
        return Answer.UNKNOWN;
    }
}
