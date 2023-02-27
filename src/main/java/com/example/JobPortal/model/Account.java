package com.example.JobPortal.model;

import com.example.JobPortal.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String username;
    String password;
    String mail;
    String name;
    String surname;
    String aboutAccount;
    String phoneNumber;
    String companyName;
    String since;

    @Enumerated(value = EnumType.STRING)
    Role role;

    @Lob
    byte[] picture;
    boolean isCompany;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (isCompany) {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_COMPANY"));
        } else {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
