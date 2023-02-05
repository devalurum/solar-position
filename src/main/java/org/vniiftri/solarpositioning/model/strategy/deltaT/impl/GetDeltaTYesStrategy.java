package org.vniiftri.solarpositioning.model.strategy.deltaT.impl;

import net.e175.klaus.solarpositioning.DeltaT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.deltaT.GetDeltaTStrategy;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Scanner;

@Component
public class GetDeltaTYesStrategy implements GetDeltaTStrategy<Double> {

    @Value("${vniiftri.timezone}")
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
