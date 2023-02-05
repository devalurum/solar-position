package org.vniiftri.solarpositioning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.datetime.GetDateTimeStrategy;
import org.vniiftri.solarpositioning.model.strategy.deltaT.GetDeltaTStrategy;
import org.vniiftri.solarpositioning.model.strategy.geolocation.GetGeolocationStrategy;
import org.vniiftri.solarpositioning.model.strategy.pressure.GetPressureStrategy;
import org.vniiftri.solarpositioning.model.strategy.save.SaveStrategy;
import org.vniiftri.solarpositioning.model.strategy.temperature.GetTemperatureStrategy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class StrategiesConfig {

    @Bean
    public Map<Answer, GetDateTimeStrategy<?>> getDateTimeStrategiesMap(List<GetDateTimeStrategy<?>> groupingStrategies) {
        return groupingStrategies.stream().collect(Collectors.toMap(GetDateTimeStrategy::getAnswer, Function.identity()));
    }

    @Bean
    public Map<Answer, GetGeolocationStrategy<?>> getGeolocationStrategiesMap(List<GetGeolocationStrategy<?>> groupingStrategies) {
        return groupingStrategies.stream().collect(Collectors.toMap(GetGeolocationStrategy::getAnswer, Function.identity()));
    }

    @Bean
    public Map<Answer, GetDeltaTStrategy<?>> getGetDeltaTStrategiesMap(List<GetDeltaTStrategy<?>> groupingStrategies) {
        return groupingStrategies.stream().collect(Collectors.toMap(GetDeltaTStrategy::getAnswer, Function.identity()));
    }

    @Bean
    public Map<Answer, GetPressureStrategy<?>> getPressureStrategiesMap(List<GetPressureStrategy<?>> groupingStrategies) {
        return groupingStrategies.stream().collect(Collectors.toMap(GetPressureStrategy::getAnswer, Function.identity()));
    }

    @Bean
    public Map<Answer, GetTemperatureStrategy<?>> getTemperatureStrategiesMap(List<GetTemperatureStrategy<?>> groupingStrategies) {
        return groupingStrategies.stream().collect(Collectors.toMap(GetTemperatureStrategy::getAnswer, Function.identity()));
    }

    @Bean
    public Map<Answer, SaveStrategy<?>> getSaveStrategiesMap(List<SaveStrategy<?>> saveStrategies) {
        return saveStrategies.stream().collect(Collectors.toMap(SaveStrategy::getAnswer, Function.identity()));
    }
}
