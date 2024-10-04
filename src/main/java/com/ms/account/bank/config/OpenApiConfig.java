package com.ms.account.bank.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de cuentas de banco y movimientos",
                version = "1.0.0",
                description = "API para la gestion de cuentas de banco y movimientos"
        )
)
public class OpenApiConfig {
}
