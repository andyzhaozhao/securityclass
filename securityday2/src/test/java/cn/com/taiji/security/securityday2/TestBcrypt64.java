package cn.com.taiji.security.securityday2;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBcrypt64 {
    public static void main(String[] args) {
        String u = "89809809908098908908978";
        System.out.println(new BCryptPasswordEncoder().encode(u));
    }
}
