package com.warren.fleet.security.jwt;

import com.warren.fleet.security.domain.Role;
import com.warren.fleet.security.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }
    public static JwtUser create(User user){
        return new JwtUser(
                user.getUid(),
                user.getUname(),
                user.getUpasswd(),
                mapToAuthorities(user.getRoles())
        );
    }

    public static JwtUser create(int id, String username, String password, Collection<? extends GrantedAuthority> authorities){
        return new JwtUser(id,username,password,authorities);
    }

    public static JwtUser createByInfo(int id, String username, String password, Collection<? extends GrantedAuthority> authorities, Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Boolean enabled){
        return new JwtUser(id,username,"",authorities,isAccountNonExpired,isAccountNonLocked,isCredentialsNonExpired,enabled);
    }

    private static List<GrantedAuthority> mapToAuthorities(List<Role> roles){

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Role role:roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRname()));
        }
        return grantedAuthorities;
    }
}
