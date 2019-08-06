package cn.com.taiji.security.securityday3.web;

import cn.com.taiji.security.securityday3.config.WebSecurityConfig;
import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class CaptchaController {
    private Logger logger = LoggerFactory.getLogger(CaptchaController.class);

    @Autowired
    private Producer captchaProducer;

    @GetMapping("/captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse
            response) throws IOException { // 设置内容类型
        response.setContentType("image/jpeg");
        // 创建验证码文本
        String capText = captchaProducer.createText();

        // 将验证码文本设置到 session
        request.getSession().setAttribute(WebSecurityConfig.CAPTCHA_SESSION_KEY, capText);

        // 创建验证码图片
        BufferedImage bi = captchaProducer.createImage(capText);

        // 获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        // 将图片验证码数据写到响应输出流
        ImageIO.write(bi, "jpg", out);

        // 推送并关闭响应输出流
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
