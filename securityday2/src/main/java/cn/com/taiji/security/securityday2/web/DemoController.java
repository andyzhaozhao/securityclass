package cn.com.taiji.security.securityday2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String demo1() {
        return "Hello World.This is my first Spring Security controller demo!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "return admin";
    }

    @GetMapping("/user")
    public String user() {
        return "return user";
    }
}
