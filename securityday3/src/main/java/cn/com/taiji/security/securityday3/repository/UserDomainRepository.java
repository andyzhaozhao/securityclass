package cn.com.taiji.security.securityday3.repository;

import cn.com.taiji.security.securityday3.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDomainRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
