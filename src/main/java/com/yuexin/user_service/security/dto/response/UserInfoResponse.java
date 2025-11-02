package com.yuexin.user_service.security.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserInfoResponse {
    private Long userId;
    private String userName;
    private String email;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private LocalDate credentialsExpiryDate;
    private LocalDate accountExpiryDate;
    private boolean isTwoFactorSecret;
    private List<String> roles;

    public UserInfoResponse(Long userId, String userName, String email, boolean accountNonLocked,
                            boolean accountNonExpired, boolean credentialsNonExpired, boolean enabled,
                            LocalDate credentialsExpiryDate, LocalDate accountExpiryDate,
                            boolean isTwoFactorSecret, List<String> roles) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.accountNonLocked = accountNonLocked;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.credentialsExpiryDate = credentialsExpiryDate;
        this.accountExpiryDate = accountExpiryDate;
        this.isTwoFactorSecret = isTwoFactorSecret;
        this.roles = roles;
    }
}