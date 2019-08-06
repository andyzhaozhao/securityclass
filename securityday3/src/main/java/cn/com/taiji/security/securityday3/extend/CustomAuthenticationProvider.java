package cn.com.taiji.security.securityday3.extend;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

//public class CustomAuthenticationProvider implements AuthenticationProvider {
//public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

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
            throws AuthenticationException{
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

//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        // 编写更多校验逻辑
//
//        // 校验密码
//        if (authentication.getCredentials() == null) {
//            throw new BadCredentialsException(
//                    this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "密码不能为空"));
//        } else {
//            String presentedPassword =
//                    authentication.getCredentials().toString();
//            if (!presentedPassword.equals(userDetails.getPassword())) {
//                throw new BadCredentialsException(
//                        this.messages.getMessage("AbstractUserDetailsAuthent icationProvider.badCredentials", "密码错误"));
//            }
//        }
//    }
//
//    @Override
//    protected UserDetails retrieveUser(String username,
//                                       UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        return userDetailsService.loadUserByUsername(username);
//    }

//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
}
