package com.dazhi.baseprovider.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerApp {
    // 定义分隔符
    private static final String splitor = ";";

    @Bean
    public Docket createRestApi() {// 创建API基本信息
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select() //
                .apis(basePackage("com.dazhi.baseprovider.blog.controller"
                        + splitor + "com.dazhi.baseprovider.base.controller"
                        + splitor + "com.dazhi.baseprovider.common")) //
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder()
                // 页面标题
                .title("Spring Boot 使用 Swagger2 构建RESTful API")
                // 创建人
                .contact(new Contact("dazhi", "", ""))
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述").build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.getHandlerMethod().getMethod().getDeclaringClass());
    }

    /**
     * swagger2原始ui
     * http://localhost:8080/swagger-ui.html
     *
     * swagger-ui-layer访问ui
     * http://localhost:8080/docs.html
     */
	/*@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// 为当前包路径
				.apis(RequestHandlerSelectors.basePackage("com.dazhi.game.base.controller"))
				// .apis(RequestHandlerSelectors.basePackage("com.dazhi.game.shop.controller"))
				.paths(PathSelectors.any())
				.build();
		// return new
		// Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
	}

	// 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 页面标题
				.title("Spring Boot 使用 Swagger2 构建RESTful API")
				// 创建人
				.contact(new Contact("dazhi", "", ""))
				// 版本号
				.version("1.0")
				// 描述
				.description("API 描述").build();
	}*/
}
