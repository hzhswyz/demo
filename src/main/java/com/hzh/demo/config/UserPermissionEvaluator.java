package com.hzh.demo.config;

import java.io.Serializable;

import com.hzh.demo.model.User;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserPermissionEvaluator implements PermissionEvaluator{

        private static final GrantedAuthority ADMINAUTHORITY = new SimpleGrantedAuthority("ROLE_admin") ;

        public boolean hasPermission (Authentication authentication, Object target, Object permission) {

        if (target instanceof User) {
            User user = (User) target;
        String username = user.getName();
        if ("delete".equals (permission)) {
            return isAdmin(authentication) || username.equals(authentication.getName());
        }
        }
        throw new UnsupportedOperationException (
        "hasPermission not supported for object <" + target
        + "> and permission <" + permission + ">") ;
        }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }


    private boolean isAdmin (Authentication authentication) {
        return authentication.getAuthorities().contains(ADMINAUTHORITY);
}
}


