package org.devalurum.solarpositioning.model.command.impl;

import lombok.RequiredArgsConstructor;
import org.devalurum.solarpositioning.model.SpaRequest;
import org.devalurum.solarpositioning.model.strategy.deltaT.GetDeltaTStrategy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.command.Command;
import org.devalurum.solarpositioning.model.strategy.Answer;
import org.devalurum.solarpositioning.utils.Utils;

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
