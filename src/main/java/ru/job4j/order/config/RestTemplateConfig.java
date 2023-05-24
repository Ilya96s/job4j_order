package ru.job4j.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig - конфигурационный класс для настрйоки RestTemplate
 *
 * @author Ilya Kaltygin
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Создает бин RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
