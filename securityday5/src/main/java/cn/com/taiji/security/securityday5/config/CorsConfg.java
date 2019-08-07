package cn.com.taiji.security.securityday5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfg {
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1
        corsConfiguration.addAllowedHeader("*"); // 2
        corsConfiguration.addAllowedMethod("*"); // 允许所有方法包括"GET", "POST", "DELETE", "PUT"等等
        corsConfiguration.setMaxAge(1800l);//30分钟
        //使用setAllowCredentials的方式解决跨域问题只支持ie10以上。
        //如果使用默认的配合CookierHttpSessionStrategy的session方式
        // 前后端一起开启，开启之后就能够读写浏览器的Cookies。该字段可选。
        // 它的值是一个布尔值，表示是否允许发送Cookie。
        // 默认情况下，Cookie不包括在CORS请求之中。
        // 设为true，即表示服务器明确许可，
        // Cookie可以包含在请求中，一起发给服务器。这个值也只能设为true，如果服务器不要浏览器发送Cookie，删除该字段即可。
        corsConfiguration.setAllowCredentials(true);

        //配合HeaderHttpSessionStrategy的session方式。token的方式解决跨域问题。
        // CORS请求时。XMLHttpRequest对象的getResponseHeader()方法只能拿到6个基本字段：Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma。如果想拿到其他字段，
        // 就必须在Access-Control-Expose-Headers里面指定。上面的例子指定，getResponseHeader(‘FooBar’)可以返回FooBar字段的值。
        //允许clienHeaderWriterFiltert-site取得自定义得header值
        corsConfiguration.addExposedHeader(HttpHeaders.AUTHORIZATION);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
