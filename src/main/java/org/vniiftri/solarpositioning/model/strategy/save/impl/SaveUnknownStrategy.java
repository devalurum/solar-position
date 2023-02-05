package org.vniiftri.solarpositioning.model.strategy.save.impl;

import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.SpaAnswer;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.save.SaveStrategy;

@Component
public class SaveUnknownStrategy implements SaveStrategy<Void> {

    @Override
    public Void save(SpaAnswer request) {
        System.out.println("Команда не распознана, попробуйте ещё раз.");
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.UNKNOWN;
    }
}
