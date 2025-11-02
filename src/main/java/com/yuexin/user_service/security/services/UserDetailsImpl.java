package com.yuexin.user_service.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yuexin.user_service.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Collection<? extends GrantedAuthority> authorities;

    private Long id;

    @JsonIgnore
    private String password;

    private String username;
    private String email;
    private boolean is2faEnabled;

    public UserDetailsImpl(Long id, String username, String email, String password,
                           boolean is2faEnabled, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.is2faEnabled = is2faEnabled;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleName().name());
        return new UserDetailsImpl(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.isTwoFactorAuthEnabled(),
                List.of(authority)
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    private Long getId() {
        return id;
    }

    private String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean is2faEnabled() {
        return is2faEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getEmail(), getPassword(), is2faEnabled, getAuthorities());
    }
}
