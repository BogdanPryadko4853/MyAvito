package com.avito.AvitoDemo.enums;

import org.springframework.security.core.GrantedAuthority;

public enum EnumsRole implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
