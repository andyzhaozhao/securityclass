package cn.com.taiji.securityclassoauth2client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SimpleController {
    @GetMapping("/")
    public String aaa(Principal principal) {
        return "hello，" + principal.getName();
    }

    @GetMapping("/hello")
    public String hello(Principal principal) {
        return "hello，" + principal.getName();
    }
}