package com.alergenko.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        // TODO: tle boš "naložil" uporabnik s firebase po emailu
        // TODO: naredi svoj class za userja (da daš vse podatke noter)
        //{noop} pove da je geslo shranjeno kot plain text ISTO MORA IMETI POSLANO GESLO
        return new User("foo","foo", new ArrayList<>());
    }
}
