package com.cours.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cours.service.UserService;

public class AppAuthProvider extends DaoAuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // login / pasword
        UsernamePasswordAuthenticationToken tkAuth = (UsernamePasswordAuthenticationToken) authentication;
        String userPassword = tkAuth.getCredentials().toString();
        String userName = tkAuth.getName();
        UserDetails user = userService.loadUserByUsername(userName);
        System.out.println("tkAuth : " + tkAuth);
        System.out.println("userPassword : " + userPassword);
        System.out.println("userName : " + userName);
        System.out.println("user : " + user);
        if (userPassword != null && passwordEncoder.matches(userPassword, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        } else {
            throw new BadCredentialsException(userName + ": Mauvais password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
