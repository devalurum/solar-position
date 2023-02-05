package org.vniiftri.solarpositioning.model.strategy.deltaT;

import org.vniiftri.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

public interface GetDeltaTStrategy<T> {

    T getDeltaT(Scanner in);

    Answer getAnswer();
}
