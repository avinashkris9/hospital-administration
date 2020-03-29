package org.allsafeclinic.hospital.administration.service;

import org.allsafeclinic.hospital.administration.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Custo implementation of spring UserDetails object.
 * ROle is a comma seperated field in database. So it is mapped to spring boot form in the constructor.
 *
 */
public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.active = user.isActive();
// here we assume the role is a comma seperate string.
        // each role is split and mapped to spring boot format "ROLE_ADMIN" and passed to Grant Authority.

        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map( roleString ->
                        new SimpleGrantedAuthority("ROLE_"+roleString))


                .collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return active;
    }
}