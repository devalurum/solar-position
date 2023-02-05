package org.vniiftri.solarpositioning.model.strategy.datetime;

import org.vniiftri.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

public interface GetDateTimeStrategy<T> {

    T getDateTime(Scanner in);

    Answer getAnswer();
}
