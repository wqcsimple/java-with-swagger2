
### 加入Swagger2 自动生成文档

#### 1. 配置方法

`build.gradle`加入以下包
```
    // swagger2 文档
    compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.8.0'
    compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.8.0'
```

#### 2. 配置文件

```java

package com.whis.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.whis.app.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格")
                .termsOfServiceUrl("https://whis.wang")
                .version("1.0")
                .build();
    }
}

```

#### 3. 访问地址

`http://localhost:8080/swagger-ui.html`