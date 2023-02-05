package org.devalurum.solarpositioning.model.strategy.save.impl;

import org.devalurum.solarpositioning.model.strategy.save.SaveStrategy;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.SpaAnswer;
import org.devalurum.solarpositioning.model.strategy.Answer;

@Component
public class SaveExitStrategy implements SaveStrategy<Void> {

    @Override
    public Void save(SpaAnswer request) {
        System.exit(0);
        return null;
    }

    @Override
    public Answer getAnswer() {
        return Answer.EXIT;
    }
}
