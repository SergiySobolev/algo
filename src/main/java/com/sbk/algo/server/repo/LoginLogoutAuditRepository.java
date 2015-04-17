package com.sbk.algo.server.repo;

import com.sbk.algo.server.entity.LoginLogoutAuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogoutAuditRepository extends JpaRepository<LoginLogoutAuditEntity, Long> {
}
