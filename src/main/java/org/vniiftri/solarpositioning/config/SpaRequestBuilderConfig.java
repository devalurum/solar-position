package org.vniiftri.solarpositioning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vniiftri.solarpositioning.model.SpaRequest;

@Configuration
public class SpaRequestBuilderConfig {

    @Bean
    public SpaRequest.SpaRequestBuilder getSpaRequestBuilder() {
        return SpaRequest.builder();
    }
}
