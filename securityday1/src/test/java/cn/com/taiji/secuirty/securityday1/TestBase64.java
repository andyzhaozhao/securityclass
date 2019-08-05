package cn.com.taiji.secuirty.securityday1;

import java.util.Base64;

public class TestBase64 {
    public static void main(String[] args) {
        String u = "user";
        String p = "1";
        byte[] basicbytes = Base64.getEncoder().encode((u+":"+p).getBytes());

        System.out.println(basicbytes);
    }
}
