package co.com.meli.configurations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

  @Bean
  public OpenAPI customOpenAPI(
      @Value("${spring.application.name}") String apiTitle,
      @Value("${spring.application.description}") String apiDescription,
      @Value("${spring.application.version}") String apiVersion) {
    return new OpenAPI()
        .components(new Components())
        .info(new Info().title(apiTitle).description(apiDescription).version(apiVersion));
  }
}
