package com.sinosoft.wordweb.chat.interceptor;

import com.alibaba.fastjson.JSON;
import com.sinosoft.wordweb.chat.domain.vo.response.Result;
import com.sinosoft.wordweb.chat.utils.JwtUtils;
import io.swagger.models.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 先处理OPTIONS请求，直接放行
        if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 获取Authorization头
        String authorization = request.getHeader("Authorization");
        log.info("authorization:{}", authorization);
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            response.setStatus(401);
            // 强制设置编码，避免中文乱码
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(Result.fail(401, "请先登录")));
            // 刷新并关闭流，确保响应发送
            writer.flush();
            writer.close();
            return false;
        }

        // 提取token
        String token = authorization.substring(7);

        // 验证token
        if (!JwtUtils.verifyToken(token)) {
            response.setStatus(401);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(Result.fail(401, "无效的token")));
            writer.flush();
            writer.close();
            return false;
        }

        // token验证通过，继续处理请求
        return true;
    }
}
