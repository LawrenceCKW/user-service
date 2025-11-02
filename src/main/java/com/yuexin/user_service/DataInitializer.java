package com.yuexin.user_service;

import com.yuexin.user_service.entity.Role;
import com.yuexin.user_service.entity.User;
import com.yuexin.user_service.model.AppRole;
import com.yuexin.user_service.repository.RoleRepository;
import com.yuexin.user_service.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(AppRole.ROLE_USER));
            roleRepository.save(new Role(AppRole.ROLE_ADMIN));
        }
        Role roleUser = roleRepository.findAll().stream()
                .filter(r -> r.getRoleName() == AppRole.ROLE_USER)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("ROLE_USER not found"));

        Role roleAdmin = roleRepository.findAll().stream()
                .filter(r -> r.getRoleName() == AppRole.ROLE_ADMIN)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("ROLE_ADMIN not found"));

        if (userRepository.count() > 0) return;

        List<User> batch = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            boolean isAdmin = i <= 2;
            String raw = "password" + i;
            String hashed = passwordEncoder.encode(raw);
            Role assignedRole = isAdmin ? roleAdmin : roleUser;

            User u = User.builder()
                    .userName("user" + i)
                    .email("user" + i + "@gmail.com")
                    .password(hashed)
                    .role(assignedRole)
                    .enabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .accountExpiryDate(LocalDate.now().plusDays(10))
                    .credentialsExpiryDate(LocalDate.now().plusYears(1))
                    .signUpMethod("LOCAL")
                    .isTwoFactorAuthEnabled(i % 5 == 0)
                    .twoFactorSecret(i % 5 == 0 ? "SECRET-" + i : null)
                    .build();

            batch.add(u);
        }

        userRepository.saveAll(batch);
    }
}
