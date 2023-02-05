package org.devalurum.solarpositioning.model.strategy.deltaT.impl;

import org.devalurum.solarpositioning.model.strategy.deltaT.GetDeltaTStrategy;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

@Component
public class GetDeltaTUnknownStrategy implements GetDeltaTStrategy<Void> {

    @Override
    public Void getDeltaT(Scanner in) {
        System.out.println("Команда не распознана, попробуйте ещё раз.");
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.UNKNOWN;
    }
}
