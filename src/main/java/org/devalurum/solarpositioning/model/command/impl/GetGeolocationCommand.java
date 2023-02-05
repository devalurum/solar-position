package org.devalurum.solarpositioning.model.command.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.Geolocation;
import org.devalurum.solarpositioning.model.SpaRequest;
import org.devalurum.solarpositioning.model.command.Command;
import org.devalurum.solarpositioning.model.strategy.Answer;
import org.devalurum.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;
import org.devalurum.solarpositioning.utils.Utils;

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
