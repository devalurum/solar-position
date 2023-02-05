package org.devalurum.solarpositioning.model.strategy;

import java.util.Arrays;
import java.util.List;

public enum Answer {
    YES("yes", "y", "да", "д"),
    NO("no", "n", "нет", "н"),
    EXIT("exit", "quit", "выход"),
    UNKNOWN();

    public final List<String> answers;

    Answer(String... answers) {
        this.answers = Arrays.asList(answers);
    }

    public static Answer getAnswer(String label) {
        return Arrays.stream(values())
                .filter(answer -> answer.answers.contains(label.toLowerCase()))
                .findFirst()
                .orElse(Answer.UNKNOWN);
    }
}
