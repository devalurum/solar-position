package org.vniiftri.solarpositioning.model.strategy.datetime.impl;

import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.datetime.GetDateTimeStrategy;
import org.vniiftri.solarpositioning.utils.Utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Scanner;

@Component
public class GetDateTimeNoStrategy implements GetDateTimeStrategy<ZonedDateTime> {

    @Override
    public ZonedDateTime getDateTime(Scanner in) {
        try {
            System.out.printf("Введите текущую дату и время в формате '%s': \n", Utils.DATE_FORMAT_DD_MM_YYYY_HH_MM_SS);
            LocalDateTime localDateTime = LocalDateTime.parse(in.nextLine(), Utils.DATE_TIME_FORMATTER);

            System.out.println("Введите часовой пояс (UTC): ");
            String timezone = in.nextLine();
            ZoneOffset zoneOffset = ZoneOffset.ofHours(Integer.parseInt(timezone));

            return localDateTime.atZone(zoneOffset);
        } catch (Exception e) {
            System.out.println("Не удалось распознать дату или часовой пояс, попробуйте ещё раз.");
            return getDateTime(in);
        }
    }

    @Override
    public Answer getAnswer() {
        return Answer.NO;
    }
}
