package org.devalurum.solarpositioning.model.strategy.save;

import org.devalurum.solarpositioning.model.SpaAnswer;
import org.devalurum.solarpositioning.model.strategy.Answer;

public interface SaveStrategy<T> {

    T save(SpaAnswer spaAnswer);

    Answer getAnswer();
}
