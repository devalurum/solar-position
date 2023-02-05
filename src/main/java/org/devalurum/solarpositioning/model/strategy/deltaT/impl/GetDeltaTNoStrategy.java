package org.devalurum.solarpositioning.model.strategy.deltaT.impl;

import org.devalurum.solarpositioning.model.strategy.deltaT.GetDeltaTStrategy;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;

import java.util.Scanner;

@Component
public class GetDeltaTNoStrategy implements GetDeltaTStrategy<Double> {

    @Override
    public Double getDeltaT(Scanner in) {
        try {
            System.out.println("Введите дельта T (сек.): ");
            String deltaT = in.nextLine();
            return Double.parseDouble(deltaT);
        } catch (Exception e) {
            System.out.println("Не удалось распознать дельта T. Попробуйте ещё раз.");
            return this.getDeltaT(in);
        }
    }

    @Override
    public Answer getAnswer() {
        return Answer.NO;
    }
}
