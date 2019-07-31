package cn.superbio.spbbase.core.swagger;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = SwaggerProperties.SWAGGER_PREFIX)
public class SwaggerProperties {
    static final String SWAGGER_PREFIX = "swagger";

    /**
     * 是否启用Swagger
     */
    private boolean enabled = false;

    /**
     * Api文档标题
     */
    private String title = "Api文档";

    /**
     * Api文档描述
     */
    private String description;

    /**
     * Api文档版本
     */
    private String version;

    /**
     * 服务条款Url
     */
    private String termsOfServiceUrl;

    /**
     * 待显示的接口的包（采用包扫描的方式）
     */
    private String basePackage;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Api文档标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Api文档标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Api文档描述
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Api文档描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Api文档版本
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * Api文档版本
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 服务条款Url
     */
    public String getTermsOfServiceUrl() {
        return this.termsOfServiceUrl;
    }

    /**
     * 服务条款Url
     */
    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    /**
     * 待显示的接口的包（采用包扫描的方式）
     */
    public String getBasePackage() {
        return basePackage;
    }

    /**
     * 待显示的接口的包（采用包扫描的方式）
     */
    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}