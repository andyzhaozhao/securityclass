package cn.com.taiji.security.securityday3.service;

import cn.com.taiji.security.securityday3.domain.UserInfo;

public interface UserDomainService {
    UserInfo findByUsername(String username);
}
