package cn.com.taiji.security.securityday3.config;

import cn.com.taiji.security.securityday3.repository.PermissionReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CustomAuthService {
    @Autowired
    private PermissionReporitory permissionReporitory;

    public Boolean canAccess(HttpServletRequest request,
                             Authentication authentication) {
        // 动态鉴权逻辑
        // 1. 先判断当前的用户有没有认证过
        Object principal = authentication.getPrincipal();
        if (principal == null || "anonymousUser".equals(principal)) {
            return false;
        }

        // 2. 如果是匿名的角色 ROLE_ANONYMOUS

        // 3. 动态鉴权逻辑
        // User
        // Role
        // Permission uid，url接口  的对应关系


        return true;
    }
}
