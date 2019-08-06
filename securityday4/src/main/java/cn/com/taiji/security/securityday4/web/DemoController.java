package cn.com.taiji.security.securityday4.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/admin")
    public String admin() {
        return "return admin";
    }

    @GetMapping("/user")
    public String user() {
        return "return user";
    }

    @GetMapping("/a")
    public String a() {
        return "return a";
    }

    @GetMapping("/b")
    public String b() {
        return "return b";
    }
}
