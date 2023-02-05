package org.vniiftri.solarpositioning.model.command.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.SpaRequest;
import org.vniiftri.solarpositioning.model.command.Command;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.deltaT.GetDeltaTStrategy;
import org.vniiftri.solarpositioning.utils.Utils;

import java.util.Map;
import java.util.Scanner;

@Component("DeltaT")
@Order(3)
@RequiredArgsConstructor
public class GetDeltaTCommand implements Command {
    private final SpaRequest.SpaRequestBuilder spaReqBuilder;
    private final Map<Answer, GetDeltaTStrategy<?>> getDeltaTStrategyMap;

    @Override
    public void execute(Scanner in) {
        System.out.println("Использовать автоматический подсчёт дельта T? (y/n): ");
        String input = in.nextLine();

        Answer answer = Answer.getAnswer(input);
        GetDeltaTStrategy<?> getDeltaTStrategy = getDeltaTStrategyMap.get(answer);
        Object object = getDeltaTStrategy.getDeltaT(in);

        if (object instanceof Double) {
            spaReqBuilder.deltaT((Double) object);
        } else if (Utils.isNull(object)) {
            this.execute(in);
        }
    }

}
