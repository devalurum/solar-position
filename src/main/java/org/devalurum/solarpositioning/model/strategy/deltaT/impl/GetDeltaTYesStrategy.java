package org.devalurum.solarpositioning.model.strategy.deltaT.impl;

import net.e175.klaus.solarpositioning.DeltaT;
import org.devalurum.solarpositioning.model.strategy.deltaT.GetDeltaTStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.strategy.Answer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Scanner;

@Component
public class GetDeltaTYesStrategy implements GetDeltaTStrategy<Double> {

    @Value("${app.timezone}")
    private int timezone;

    private final ZoneId zoneId = ZoneOffset.ofHours(timezone);

    @Override
    public Double getDeltaT(Scanner in) {
        return DeltaT.estimate(LocalDateTime.now().atZone(zoneId).toLocalDate());
    }

    @Override
    public Answer getAnswer() {
        return Answer.YES;
    }
}
