package org.vniiftri.solarpositioning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.vniiftri.solarpositioning.model.command.Command;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class CommandConfig {

    @Bean
    public List<Command> getListCommands(List<Command> commands) {
        return commands.stream()
                .sorted(Comparator.comparingInt(c -> c.getClass().getAnnotation(Order.class).value()))
                .collect(Collectors.toList());
    }
}
