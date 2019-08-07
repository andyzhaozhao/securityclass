package cn.com.taiji.security.securityday5.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/admin")
    public String admin() {
        return "return admin";
    }

    @GetMapping("/user")
    public String user() {
        return "return user";
    }

    @DeleteMapping("/user")
    public String d() {
        return "删除用户成功";
    }

//    @CrossOrigin
    @PutMapping("/user")
    public String update() {
        return "更新用户成功";
    }

    @PostMapping("/user")
    public String add() {
        return "增加用户成功";
    }

    @GetMapping("/a")
    public String a() {
        return "return a";
    }
    @GetMapping("/b")
    public Object b() {
        Object result = restTemplate.getForObject("https://www.baidu.com/",String.class);
        return result;
    }
}
