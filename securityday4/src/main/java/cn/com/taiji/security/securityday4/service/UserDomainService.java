package cn.com.taiji.security.securityday4.service;

import cn.com.taiji.security.securityday4.domain.UserInfo;

public interface UserDomainService {
    UserInfo findByUsername(String username);
}
