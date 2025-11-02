package com.yuexin.user_service.service.implementation;

import com.yuexin.user_service.dto.UserDTO;
import com.yuexin.user_service.dto.UserPageDTO;
import com.yuexin.user_service.entity.Role;
import com.yuexin.user_service.entity.User;
import com.yuexin.user_service.model.AppRole;
import com.yuexin.user_service.repository.RoleRepository;
import com.yuexin.user_service.repository.UserRepository;
import com.yuexin.user_service.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserPageDTO getUsers(Integer page) {
        int pageNo = page < 1 ? 0 : page -1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdDate");
        Page<UserDTO> userPage = userRepository.findUsers(pageable);
        return new UserPageDTO(userPage);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public void updateUserRole(Long userId, String roleName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        AppRole appRole = AppRole.valueOf(roleName);
        Role role = roleRepository.findByRoleName(appRole)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUserName(username);
        return user.orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

}
