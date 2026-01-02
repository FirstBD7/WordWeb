package com.sinosoft.wordweb.chat.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    // 密钥（建议放在配置文件中，这里为了演示直接写）
    // 实际项目中：@Value("${jwt.secret}")
    private static final String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz123456yjghujghchvjbknkhgchjk";

    // token有效期（2小时，单位：毫秒）
    // 实际项目中：@Value("${jwt.expiration}")
    private static final long EXPIRATION_TIME = 2 * 60 * 60 * 1000;

    // 生成JWT token
    public static String generateToken(String username) {
        // 当前时间
        Date now = new Date();
        // 过期时间
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

        // 构建JWT token
        return Jwts.builder()
                // 1. 设置Header（类型和算法）
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                // 2. 设置Payload（用户信息和过期时间）
                .setSubject(username)  // 设置用户名（必须）
                .setIssuedAt(now)      // 设置签发时间
                .setExpiration(expirationDate)  // 设置过期时间
                // 可以添加更多自定义信息（可选）
                // .claim("role", "admin")  // 比如用户角色

                // 3. 设置Signature（签名，防止伪造）
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)

                // 4. 压缩成String格式
                .compact();
    }

    // 验证token是否有效
    public static boolean verifyToken(String token) {
        try {
            // 解析token（会自动验证签名和过期时间）
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;  // 验证通过
        } catch (Exception e) {
            // 验证失败（过期、签名错误、格式错误等）
            return false;
        }
    }

    // 从token中获取用户名
    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();  // 返回用户名
    }
}