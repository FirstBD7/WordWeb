package com.sinosoft.wordweb.chat.config;

import com.sinosoft.wordweb.chat.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                // 拦截所有请求，再排除不需要拦截的路径（推荐写法，更清晰）
                .addPathPatterns("/**")
                // 排除登录接口（支持模糊匹配，适配路径后缀/大小写等场景）
                .excludePathPatterns(
                        "/user/login",          // 精确匹配
                        "/user/login/**",       // 模糊匹配子路径
                        "/user/Login",          // 兼容大小写（若有需要）
                        "/user/login.json"      // 兼容后缀（若有需要）
                );
                // 若有其他无需拦截的路径（如注册、静态资源），继续添加
//                .excludePathPatterns("/user/register", "/static/**", "/error");
    }
}
