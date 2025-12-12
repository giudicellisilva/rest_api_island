package elias.giudicelli.rest_api_island.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI gameApiDoc() {
	    return new OpenAPI()
	            .openapi("2.3.0")
	            .components(new Components()
	                    .addSecuritySchemes("bearer-jwt",
	                            new SecurityScheme()
	                                    .type(SecurityScheme.Type.HTTP)
	                                    .scheme("bearer")
	                                    .bearerFormat("JWT")))
	            .addSecurityItem(new SecurityRequirement().addList("bearer-jwt"))
	            .info(new Info()
	                    .title("Island API")
	                    .version("1.0")
	                    .description("Documentação interativa da API do jogo (Spring Boot + Next.js)"));
	}
}
