package cn.com.taiji.security.securityday2.extend;

import cn.com.taiji.security.securityday2.domain.Role;
import cn.com.taiji.security.securityday2.domain.UserInfo;
import cn.com.taiji.security.securityday2.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserDomainService userDomainService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userDomain = userDomainService.findByUsername(username);
        if (userDomain == null) {
            throw new UsernameNotFoundException("没有此用户");
        }

//        //定义权限列表
//        //Authority: ROLE, SCOPE, GROUP ,.........
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        //用户可以访问的资源名称（或者说用户所拥有的权限)注意：必须"ROLE_"开头
//        authorities.add(new SimpleGrantedAuthority(userDomain.getRoles().name()));

        //定义权限列表.
        List<GrantedAuthority> authorities = new ArrayList<>();
        //或者说用户所拥有的权限,如果是ROLE based authority，注意：必须"ROLE_"开头
        for (Role role : userDomain.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        User userDetails = new org.springframework.security.core.userdetails.User(userDomain.getUsername(),
                userDomain.getPassword(), authorities);
        return userDetails;
    }
}
