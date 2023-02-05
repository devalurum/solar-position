package org.devalurum.solarpositioning.model.strategy.datetime.impl;

import org.devalurum.solarpositioning.model.strategy.datetime.GetDateTimeStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Scanner;

@Component
public class GetDateTimeYesStrategy implements GetDateTimeStrategy<ZonedDateTime> {

    @Value("${app.timezone}")
    private int timezone;

    @Override
    public ZonedDateTime getDateTime(Scanner in) {
        return ZonedDateTime.now(ZoneOffset.ofHours(timezone));
    }

    @Override
    public Answer getAnswer() {
        return Answer.YES;
    }
}
