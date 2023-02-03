package com.example.JobPortal.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    User,
    Company,
    Admin;

    @Override
    public String getAuthority() {
        return name();
    }
}