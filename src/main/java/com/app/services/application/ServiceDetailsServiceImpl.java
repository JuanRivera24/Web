package com.app.services.application;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.services.domain.IServiceRepository;
import com.app.services.domain.Service;

@Service
public class ServiceDetailsServiceImpl implements UserDetailsService {

    private final IServiceRepository serviceRepository;

    public ServiceDetailsServiceImpl(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Service service = serviceRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Service not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(
                service.getEmail(),
                service.getPassword(),
                new ArrayList<>());
    }
}
