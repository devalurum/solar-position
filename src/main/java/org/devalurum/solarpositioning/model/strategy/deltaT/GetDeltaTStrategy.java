package org.devalurum.solarpositioning.model.strategy.deltaT;

import org.devalurum.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

public interface GetDeltaTStrategy<T> {

    T getDeltaT(Scanner in);

    Answer getAnswer();
}
