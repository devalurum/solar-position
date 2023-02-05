package org.vniiftri.solarpositioning.model.command.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.SpaRequest;
import org.vniiftri.solarpositioning.model.command.Command;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.temperature.GetTemperatureStrategy;
import org.vniiftri.solarpositioning.service.SpaService;

import java.util.Map;
import java.util.Scanner;

@Component("Temperature")
@Order(5)
@RequiredArgsConstructor
public class GetTemperatureCommand implements Command {
    private final SpaRequest.SpaRequestBuilder spaReqBuilder;
    private final Map<Answer, GetTemperatureStrategy<?>> getTemperatureStrategyMap;

    private final SpaService spaService;

    @Override
    public void execute(Scanner in) {
        System.out.println("Введите среднегодовую температуру (°C): ");
        String input = in.nextLine();

        Answer answer = Answer.getAnswer(input);

        if (answer == Answer.UNKNOWN) {
            try {
                GetTemperatureStrategy<?> getTemperatureStrategy = getTemperatureStrategyMap.get(answer);
                Double temperature = Double.parseDouble(input);
                spaReqBuilder.temperature((Double) getTemperatureStrategy.getTemperature(temperature));

                SpaRequest spaRequest = spaReqBuilder.build();
                String result = spaService.getAzimuthZenithAngle(spaRequest);

                System.out.println(result);
            } catch (Exception ex) {
                System.out.println("Не удалось распознать температуру, попробуйте ещё раз.");
                this.execute(in);
            }
        } else if (answer == Answer.EXIT) {
            GetTemperatureStrategy<?> exitStrategy = getTemperatureStrategyMap.get(answer);
            exitStrategy.getTemperature(null);
        } else {
            System.out.println("Не удалось распознать температуру, попробуйте ещё раз.");
            this.execute(in);
        }
    }
}