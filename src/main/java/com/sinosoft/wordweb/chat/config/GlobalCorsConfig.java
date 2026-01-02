package com.sinosoft.wordweb.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置类
 */
@Configuration // 标记为配置类，Spring启动时自动加载
public class GlobalCorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 对所有接口生效（可改为特定路径，如"/word/**"）
                // 允许的前端域名（多个域名用逗号分隔，或用"*"允许所有，但不建议生产环境用"*"）
                .allowedOrigins("http://localhost:8080")
                // 允许的HTTP请求方法（GET/POST/PUT/DELETE等）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 允许的请求头（如自定义的Token头、Content-Type等）
                .allowedHeaders("*")
                // 允许前端传递Cookie等凭证（需配合前端的withCredentials: true）
                .allowCredentials(true)
                // 预检请求（OPTIONS）的缓存时间（单位：秒，避免频繁发预检请求）
                .maxAge(3600);
    }
}
