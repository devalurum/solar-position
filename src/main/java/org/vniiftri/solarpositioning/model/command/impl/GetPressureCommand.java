package org.vniiftri.solarpositioning.model.command.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.SpaRequest;
import org.vniiftri.solarpositioning.model.command.Command;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.pressure.GetPressureStrategy;

import java.util.Map;
import java.util.Scanner;

@Component("Pressure")
@Order(4)
@RequiredArgsConstructor
public class GetPressureCommand implements Command {
    private final SpaRequest.SpaRequestBuilder spaReqBuilder;
    private final Map<Answer, GetPressureStrategy<?>> getPressureStrategyMap;

    @Override
    public void execute(Scanner in) {
        System.out.println("Введите среднегодовое давление (мм.рт.ст): ");
        String input = in.nextLine();

        Answer answer = Answer.getAnswer(input);

        if (answer == Answer.UNKNOWN) {
            try {
                GetPressureStrategy<?> getPressureStrategy = getPressureStrategyMap.get(answer);
                Double pressure = Double.parseDouble(input);
                spaReqBuilder.pressure((Double) getPressureStrategy.getPressure(pressure));
            } catch (Exception ex) {
                System.out.println("Не удалось распознать давление, попробуйте ещё раз.");
                this.execute(in);
            }
        } else if (answer == Answer.EXIT) {
            GetPressureStrategy<?> exitStrategy = getPressureStrategyMap.get(answer);
            exitStrategy.getPressure(null);
        } else {
            System.out.println("Не удалось распознать давление, попробуйте ещё раз.");
            this.execute(in);
        }
    }
}
