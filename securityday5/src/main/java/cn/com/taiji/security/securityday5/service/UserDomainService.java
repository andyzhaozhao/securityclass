package cn.com.taiji.security.securityday5.service;

import cn.com.taiji.security.securityday5.domain.UserInfo;

public interface UserDomainService {
    UserInfo findByUsername(String username);
}
