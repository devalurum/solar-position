package org.vniiftri.solarpositioning.model.strategy.deltaT.impl;

import net.e175.klaus.solarpositioning.DeltaT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.deltaT.GetDeltaTStrategy;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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
