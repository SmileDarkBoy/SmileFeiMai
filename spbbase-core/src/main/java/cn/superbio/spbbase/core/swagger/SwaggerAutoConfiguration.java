package cn.superbio.spbbase.core.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger", name = "enabled")
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerAutoConfiguration {
    private final SwaggerProperties properties;

    public SwaggerAutoConfiguration(SwaggerProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Docket api() {
//        ParameterBuilder parameterBuilder = new ParameterBuilder();
//        List<Parameter> parameters = new ArrayList<>();ListUtils
//        parameters.add(parameterBuilder.name("token").description("令牌").modelRef(new ModelRef("string"))
//                .parameterType("query").required(false).build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET, getResponseMessage())
                .globalResponseMessage(RequestMethod.POST, postResponseMessage())
                .globalResponseMessage(RequestMethod.PUT, postResponseMessage())
                .globalResponseMessage(RequestMethod.DELETE, deleteResponseMessage())
//                .globalOperationParameters(parameters)
                .select()
                .apis((properties.getBasePackage() == null || properties.getBasePackage().isEmpty()) ?
                        RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class) :
                        RequestHandlerSelectors.basePackage(properties.getBasePackage()))//这里采用包含注解的方式或包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .termsOfServiceUrl(properties.getTermsOfServiceUrl())
                .version(properties.getVersion())
                .build();
    }

    private List<ResponseMessage> getResponseMessage() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("请求成功").build());
//        responseMessageList.add(new ResponseMessageBuilder().code(400).message("请求参数有误").build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("未登录").build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("未授权").build());
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").build());

        return responseMessageList;
    }

    private List<ResponseMessage> postResponseMessage() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(201).message("操作成功").build());
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("请求参数有误").build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("未登录").build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("未授权").build());
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").build());

        return responseMessageList;
    }

    private List<ResponseMessage> deleteResponseMessage() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(204).message("删除成功").build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("未登录").build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("未授权").build());

        return responseMessageList;
    }
}
