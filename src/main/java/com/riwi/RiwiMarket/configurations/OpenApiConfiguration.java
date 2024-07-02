package com.riwi.RiwiMarket.configurations;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Riwi Market",
        version = "1.0",
        description = "EndPoint documentation of the Riwi Market"
    )
)
public class OpenApiConfiguration {
    
}