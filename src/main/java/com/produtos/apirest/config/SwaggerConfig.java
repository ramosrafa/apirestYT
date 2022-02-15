package com.produtos.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.produtos.apirest.models.Produto;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))
				.paths(PathSelectors.ant("/api/**"))
				.build()
				.ignoredParameterTypes(Produto.class)
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		return new ApiInfoBuilder().title("Título da API").version("1.0.0").description("rocharafaelramos@gmail.com").build();
	}

}
