package com.williamspires.acnhapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Animal Crossing New Horizons API")
                .description("Data sourced mostly from https://tinyurl.com/acnh-sheet " +
                        "and a few other resources found in https://discord.gg/8jNFHxG"));
    }
}
