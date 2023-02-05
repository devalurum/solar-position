package org.devalurum.solarpositioning.model.strategy.datetime.impl;

import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;
import org.devalurum.solarpositioning.model.strategy.datetime.GetDateTimeStrategy;

import java.util.Scanner;

@Component
public class GetDateTimeUnknownStrategy implements GetDateTimeStrategy<Void> {

    @Override
    public Void getDateTime(Scanner in) {
        System.out.println("Команда не распознана, попробуйте ещё раз.");
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.UNKNOWN;
    }
}
