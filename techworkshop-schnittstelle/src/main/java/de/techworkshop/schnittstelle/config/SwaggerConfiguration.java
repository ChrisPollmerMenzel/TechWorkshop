package de.techworkshop.schnittstelle.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Konfiguration für Swagger.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  /**
   * Liefert die Instanz auf das Bean für die API zurück.
   *
   * @return Bean für die API
   */
  @SuppressWarnings("Guava")
  @Bean
  public Docket api() {

    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("de.techworkshop.schnittstelle"))
        .paths(PathSelectors.any())
        .paths(Predicates.not(PathSelectors.regex("/error.*")))
        .build()
        .enableUrlTemplating(true)
        .useDefaultResponseMessages(false)
        .ignoredParameterTypes(ApiIgnore.class);
  }

  /**
   * Erstellt die API-Info und liefert diese zurück.
   *
   * @return API-Info
   */
  private ApiInfo apiInfo() {

    return new ApiInfoBuilder().title("Workshop Schnittstellen Service Api")
        .description("Schnittstellen Service.")
        .contact(new Contact("Chris Menzel", "http://www..de",
            "chris.menzel@.de"))
        .license("")
        .licenseUrl("")
        .version("1.0")
        .build();
  }

}
