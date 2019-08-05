package cn.com.taiji.security.securityday2.service;

import cn.com.taiji.security.securityday2.domain.UserInfo;

public interface UserDomainService {
    UserInfo findByUsername(String username);
}
