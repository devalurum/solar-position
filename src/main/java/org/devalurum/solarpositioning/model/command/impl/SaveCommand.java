package org.devalurum.solarpositioning.model.command.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.event.SpaEvent;
import org.devalurum.solarpositioning.model.SpaAnswer;
import org.devalurum.solarpositioning.model.command.Command;
import org.devalurum.solarpositioning.model.strategy.Answer;
import org.devalurum.solarpositioning.model.strategy.save.SaveStrategy;
import org.devalurum.solarpositioning.utils.Utils;

import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

@Component("Save")
@Order(7)
@RequiredArgsConstructor
public class SaveCommand implements Command, ApplicationListener<SpaEvent> {
    private final Map<Answer, SaveStrategy<?>> saveStrategyMap;
    private SpaAnswer spaAnswer;

    @Override
    public void execute(Scanner in) {
        System.out.println("Сохранить результат в файл? (y/n):");
        String input = in.nextLine();

        Answer answer = Answer.getAnswer(input);
        SaveStrategy<?> saveStrategy = saveStrategyMap.get(answer);
        Object object = saveStrategy.save(spaAnswer);

        if (object instanceof Path) {
            System.out.printf("Сохранено в: %s", ((Path) object).toAbsolutePath());
        } else if (Utils.isNull(object)) {
            this.execute(in);
        }
    }

    @Override
    public void onApplicationEvent(SpaEvent event) {
        this.spaAnswer = event.getSpaAnswer();
    }
}
