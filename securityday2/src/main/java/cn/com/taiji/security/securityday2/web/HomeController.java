package cn.com.taiji.security.securityday2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/myLogin")
    public String myLogin() {
        return "myLogin";
    }

}
