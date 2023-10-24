package com.surajmaity1.springbootrestapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Employee API App",
                description = "Employee API Doc",
                summary = "SPRING BOOT REST-API",
                termsOfService = "Employee Service Terms",
                contact = @Contact(
                        name = "Suraj",
                        email = "suraj@gmail.com"
                ),
                license = @License(
                        name = "Averysync License",
                        url = "https://twitter.com/averysync"
                ),
                version = "v1"
        ),
        servers = {
                @Server(
                        description = "Dev",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Prod",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {

}
