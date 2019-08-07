package cn.com.taiji.security.securityday5.extend;

import cn.com.taiji.security.securityday5.config.WebSecurityConfig;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CustomCaptchaWebAuthenticationDetails extends WebAuthenticationDetails {
    // 验证码是否正确
    private boolean imageCodeIsRight;
    // 用户输入的验证码
    private String captcha;
    // 缓存的验证码
    private String savedCaptcha;

    public CustomCaptchaWebAuthenticationDetails(HttpServletRequest request) {
        super(request);

        this.captcha = request.getParameter(WebSecurityConfig.CAPTCHA_SESSION_KEY);
        HttpSession session = request.getSession();
        this.savedCaptcha = (String) session.getAttribute(WebSecurityConfig.CAPTCHA_SESSION_KEY);

        if (!StringUtils.isEmpty(this.savedCaptcha)) {
            // 清除验证码，不管是失败，还是成功，所有客户端都应在登录失败时刷新验证码
            session.removeAttribute(WebSecurityConfig.CAPTCHA_SESSION_KEY); // 当验证码正确时设置状态
            if (!StringUtils.isEmpty(captcha) && captcha.equals(savedCaptcha)) {
                this.imageCodeIsRight = true;
            }
        }
    }

    public boolean getImageCodeIsRight() {
        return this.imageCodeIsRight;
    }
}