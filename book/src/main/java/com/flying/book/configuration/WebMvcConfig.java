package com.flying.book.configuration;

import com.flying.book.core.handler.LoginInterceptor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

@SpringBootApplication
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
public class WebMvcConfig  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    //将拦截器注入容器
    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    /**
     * 权限拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //这里参数是一个实现了HandlerInterceptor接口的拦截器
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")//需要拦截的请求
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/exit");//不拦截的请求

    }

}
