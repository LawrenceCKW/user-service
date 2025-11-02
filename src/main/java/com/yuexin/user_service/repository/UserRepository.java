package com.yuexin.user_service.repository;

import com.yuexin.user_service.dto.UserDTO;
import com.yuexin.user_service.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

import static com.yuexin.user_service.constants.SqlQuery.FIND_USERS_QUERY;
import static com.yuexin.user_service.constants.SqlQuery.FIND_USER_QUERY;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(FIND_USERS_QUERY)
    Page<UserDTO> findUsers(Pageable pageable);

    @Query(FIND_USER_QUERY)
    UserDTO findUserById(@Param("userId") Long userId);

    Optional<User> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
}
