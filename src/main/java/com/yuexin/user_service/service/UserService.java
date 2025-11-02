package com.yuexin.user_service.service;

import com.yuexin.user_service.dto.UserDTO;
import com.yuexin.user_service.dto.UserPageDTO;
import com.yuexin.user_service.entity.User;

public interface UserService {
    UserPageDTO getUsers(Integer page);
    UserDTO getUserById(Long id);
    void updateUserRole(Long userId, String roleName);
    User findByUsername(String username);
}
