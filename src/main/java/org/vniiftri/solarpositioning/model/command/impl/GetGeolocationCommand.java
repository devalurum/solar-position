package org.vniiftri.solarpositioning.model.command.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.Geolocation;
import org.vniiftri.solarpositioning.model.SpaRequest;
import org.vniiftri.solarpositioning.model.command.Command;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;
import org.vniiftri.solarpositioning.utils.Utils;

import java.util.Map;
import java.util.Scanner;

@Component("Geolocation")
@Order(2)
@RequiredArgsConstructor
public class GetGeolocationCommand implements Command {
    private final SpaRequest.SpaRequestBuilder spaReqBuilder;
    private final Map<Answer, GetGeolocationStrategy<?>> getGeolocationCommandMap;

    @Override
    public void execute(Scanner in) {
        System.out.println("Использовать текущее местоположение? (y/n):");
        String input = in.nextLine();

        Answer answer = Answer.getAnswer(input);
        GetGeolocationStrategy<?> getGeolocationStrategy = getGeolocationCommandMap.get(answer);
        Object object = getGeolocationStrategy.getGeolocation(in);

        if (object instanceof Geolocation) {
            spaReqBuilder.geolocation((Geolocation) object);
        } else if (Utils.isNull(object)) {
            this.execute(in);
        }
    }

}
