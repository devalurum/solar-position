package org.devalurum.solarpositioning.model.command.impl;

import lombok.RequiredArgsConstructor;
import org.devalurum.solarpositioning.model.SpaRequest;
import org.devalurum.solarpositioning.model.strategy.datetime.GetDateTimeStrategy;
import org.devalurum.solarpositioning.utils.Utils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.command.Command;
import org.devalurum.solarpositioning.model.strategy.Answer;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Scanner;

@Component("DateTime")
@Order(1)
@RequiredArgsConstructor
public class GetDateTimeCommand implements Command {
    private final SpaRequest.SpaRequestBuilder spaReqBuilder;
    private final Map<Answer, GetDateTimeStrategy<?>> getDateTimeStrategyMap;

    @Override
    public void execute(Scanner in) {
        System.out.println("Использовать системное время? (y/n):");
        String input = in.nextLine();

        Answer answer = Answer.getAnswer(input);
        GetDateTimeStrategy<?> getDateTimeStrategy = getDateTimeStrategyMap.get(answer);
        Object object = getDateTimeStrategy.getDateTime(in);

        if(object instanceof ZonedDateTime){
            spaReqBuilder.dateTime((ZonedDateTime) object);
        } else if (Utils.isNull(object)) {
            this.execute(in);
        }
    }

}
