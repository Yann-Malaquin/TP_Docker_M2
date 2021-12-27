package fr.yannm.annuaire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Yann
 * @version 1.0
 * @name : SwaggerConfig
 * @created 27/12/2021 - 15:02
 * @project Annuaire
 * @copyright Yann
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.yannm.annuaire.model")
                        .or(RequestHandlerSelectors.basePackage("fr.yannm.annuaire.controller")))
                .build();
    }

    // Describe your apis
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Annuaire API")
                .description("API to access to the website Annuaire")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
