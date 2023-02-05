package org.devalurum.solarpositioning.model.strategy.save.impl;

import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.SpaAnswer;
import org.devalurum.solarpositioning.model.strategy.Answer;
import org.devalurum.solarpositioning.model.strategy.save.SaveStrategy;

@Component
public class SaveNoStrategy implements SaveStrategy<Void> {

    @Override
    public Void save(SpaAnswer request) {
        System.exit(0);
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.NO;
    }
}
