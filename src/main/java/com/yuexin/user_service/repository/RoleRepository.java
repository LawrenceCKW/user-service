package com.yuexin.user_service.repository;

import com.yuexin.user_service.entity.Role;
import com.yuexin.user_service.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
