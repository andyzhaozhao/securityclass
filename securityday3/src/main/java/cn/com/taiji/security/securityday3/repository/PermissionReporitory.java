package cn.com.taiji.security.securityday3.repository;

import cn.com.taiji.security.securityday3.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionReporitory extends JpaRepository<Permission, Long> {
}