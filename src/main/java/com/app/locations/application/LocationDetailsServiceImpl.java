package com.app.locations.application;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.locations.domain.ILocationRepository;
import com.app.locations.domain.Location;

@Service
public class LocationDetailsServiceImpl implements UserDetailsService {

    private final ILocationRepository locationRepository;

    public LocationDetailsServiceImpl(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Location location = locationRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Location not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(
                location.getEmail(),
                location.getPassword(),
                new ArrayList<>());
    }
}
