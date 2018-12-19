//package com.warren.fleet.security.jwt;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class JwtUser implements UserDetails {
//
//    private final int id;
//    private final String username;
//    private final String password;
//
//    private final Collection<? extends GrantedAuthority> authorities; //用户角色权限
//
//    private final Boolean isAccountNonExpired;   //账号是否过期
//
//    private final Boolean isAccountNonLocked; //账户是否锁定
//
//    private final Boolean isCredentialsNonExpired; //密码是否过期
//
//    private Boolean enabled;  //是否激活
//
//    //private final Instant lastPasswordResetDate; //上次密码重置时间
//
//
//
//
//    public JwtUser(int id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.authorities = authorities;
//        this.isAccountNonExpired = true;
//        this.isAccountNonLocked =true;
//        this.enabled = true;
//        this.isCredentialsNonExpired = true;
//    }
//
//    public JwtUser(int id, String username, String password, Collection<? extends GrantedAuthority> authorities, Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Boolean enabled) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.authorities = authorities;
//        this.isAccountNonExpired = isAccountNonExpired;
//        this.isAccountNonLocked = isAccountNonLocked;
//        this.isCredentialsNonExpired = isCredentialsNonExpired;
//        this.enabled = enabled;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return this.isAccountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.isAccountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.isCredentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.enabled;
//    }
//}
