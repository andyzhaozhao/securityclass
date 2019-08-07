package cn.com.taiji.security.securityday5.repository;

import cn.com.taiji.security.securityday5.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionReporitory extends JpaRepository<Permission, Long> {
    public Permission findByUrl(String url);
}