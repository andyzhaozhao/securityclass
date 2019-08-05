package cn.com.taiji.security.securityday3.service.impl;

import cn.com.taiji.security.securityday3.domain.UserInfo;
import cn.com.taiji.security.securityday3.repository.UserDomainRepository;
import cn.com.taiji.security.securityday3.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Autowired
    private UserDomainRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
}