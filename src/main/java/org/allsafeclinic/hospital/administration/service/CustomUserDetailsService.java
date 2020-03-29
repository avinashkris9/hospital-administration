package org.allsafeclinic.hospital.administration.service;

import org.allsafeclinic.hospital.administration.controller.StaffController;
import org.allsafeclinic.hospital.administration.entity.User;
import org.allsafeclinic.hospital.administration.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * Custom implementation of spring boot user details service
 *
 */
@Service

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {


        Optional<User> user=userRepository.findByUserName(userName);

                user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(MyUserDetails::new).get();
    }


}
