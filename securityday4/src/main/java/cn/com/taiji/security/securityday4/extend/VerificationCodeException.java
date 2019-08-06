package cn.com.taiji.security.securityday4.extend;

import org.springframework.security.core.AuthenticationException;

public class VerificationCodeException extends AuthenticationException {
    public VerificationCodeException() {
        super("图形验证码校验失败");
    }
}