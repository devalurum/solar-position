package org.devalurum.solarpositioning.model.strategy.datetime;

import org.devalurum.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

public interface GetDateTimeStrategy<T> {

    T getDateTime(Scanner in);

    Answer getAnswer();
}
