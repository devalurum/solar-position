package org.devalurum.solarpositioning.model.strategy.deltaT.impl;

import org.devalurum.solarpositioning.model.strategy.deltaT.GetDeltaTStrategy;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

@Component
public class GetDeltaTExitStrategy implements GetDeltaTStrategy<Void> {

    @Override
    public Void getDeltaT(Scanner in) {
        System.exit(0);
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.EXIT;
    }
}
