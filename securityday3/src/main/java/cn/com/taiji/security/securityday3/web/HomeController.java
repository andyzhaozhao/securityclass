package cn.com.taiji.security.securityday3.web;

import cn.com.taiji.security.securityday3.config.CustomCaptchaFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/myLogin")
    public String myLogin() {
        return "myLogin";
    }

    @GetMapping("/")
    public String index() {
        logger.info("测试热部署");
        return "index";
    }

}
