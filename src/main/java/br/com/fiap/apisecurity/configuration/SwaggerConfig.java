package br.com.fiap.apisecurity.configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("KAOW - Keep Attention on the World")
                        .version("1.0")
                        .description("Documentação da API do KAOW, Sempre te mantendo por dentro dos acontecimentos 🌍🚨")
                        .contact(new Contact()
                                .name("Thiago Mendes do Nascimento")
                                .email("offline.2606@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação Completa")
                        .url("https://github.com/Offiline26/KAOW/tree/correta"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                                .name("Authorization")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
//                .servers(List.of(
//                        new Server().url("https://kaow.onrender.com").description("Servidor do Render")
//                ));
    }
}
