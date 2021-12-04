package fr.yannm.annuaire.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yann
 * @version 1.0
 * @name : WebConfig
 * @created 04/12/2021 - 16:19
 * @project Annuaire
 * @copyright Yann
 **/
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");

    }
}
