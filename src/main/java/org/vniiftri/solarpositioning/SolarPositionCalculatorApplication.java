package org.vniiftri.solarpositioning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.vniiftri.solarpositioning.model.command.Command;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class SolarPositionCalculatorApplication implements CommandLineRunner {

    @Autowired
    private List<Command> commands;

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .web(WebApplicationType.NONE)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .headless(true)
                .sources(SolarPositionCalculatorApplication.class)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            commands.forEach(command -> command.execute(in));
        }

        TimeUnit.SECONDS.sleep(5);
    }
}


