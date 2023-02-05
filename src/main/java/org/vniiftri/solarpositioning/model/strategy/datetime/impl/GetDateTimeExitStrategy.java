package org.vniiftri.solarpositioning.model.strategy.datetime.impl;

import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.datetime.GetDateTimeStrategy;

import java.util.Scanner;

@Component
public class GetDateTimeExitStrategy implements GetDateTimeStrategy<Void> {

    @Override
    public Void getDateTime(Scanner in) {
        System.exit(0);
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.EXIT;
    }
}
