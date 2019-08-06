package cn.com.taiji.security.securityday4.repository;

import cn.com.taiji.security.securityday4.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDomainRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
