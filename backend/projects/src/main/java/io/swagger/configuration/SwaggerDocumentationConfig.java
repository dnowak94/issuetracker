package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-22T17:17:28.475276+02:00[Europe/Luxembourg]")
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Issuetracker - OpenAPI 3.0.3")
                .description("Some useful links: - [The Issuetracker repository](https://github.com/swagger-api/swagger-projectstore) - [The source API definition for the projects service](https://github.com/dnowak94/issuetracker/blob/master/backend/openapi.yaml)")
                .termsOfService("")
                .version("1.0.11")
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("dnowak94@live.de")));
    }

}
