package de.unistuttgart.towerdefensebackend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class TowerDefenseServiceConfiguration implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        // allow CORS requests for all resources and HTTP methods from the frontend origin
        registry.addMapping("/**").allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE");
    }
}
