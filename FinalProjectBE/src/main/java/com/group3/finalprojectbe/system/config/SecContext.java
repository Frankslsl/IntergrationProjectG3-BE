package com.group3.finalprojectbe.system.config;

import com.group3.finalprojectbe.system.entity.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecContext {
    public static  Long getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal userPrincipal) {
            return userPrincipal.getId();
        }

        throw new RuntimeException("getUserId error");
    }
}
