package cn.com.taiji.security.securityday5.extend;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

//自定处理图形验证码的CustomAuthenticationProvider
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    public CustomAuthenticationProvider(UserDetailsService userDetailsService,
                                        PasswordEncoder passwordEncoder) {
        // 把构造方法注入 UserDetailService 和 PasswordEncoder
        this.setUserDetailsService(userDetailsService);
        this.setPasswordEncoder(passwordEncoder);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
            throws AuthenticationException {
        //实现图形验证码的校验逻辑
        CustomCaptchaWebAuthenticationDetails details =
                (CustomCaptchaWebAuthenticationDetails) usernamePasswordAuthenticationToken.getDetails();

        // 发现验证码不正确，就立刻抛出相应异常信息
        if (!details.getImageCodeIsRight()) {
            throw new VerificationCodeException();
        }

        // 调用父类方法完成密码验证
        super.additionalAuthenticationChecks(userDetails,
                usernamePasswordAuthenticationToken);
    }
}
