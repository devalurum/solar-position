package org.vniiftri.solarpositioning.model.strategy.save;

import org.vniiftri.solarpositioning.model.SpaAnswer;
import org.vniiftri.solarpositioning.model.strategy.Answer;

public interface SaveStrategy<T> {

    T save(SpaAnswer spaAnswer);

    Answer getAnswer();
}
