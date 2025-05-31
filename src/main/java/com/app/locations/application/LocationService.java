package com.app.locations.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.locations.domain.ILocationRepository;
import com.app.locations.domain.ILocationService;
import com.app.locations.domain.Location;

@Service
public class LocationService implements ILocationService {

    private final ILocationRepository locationRepository;

    public LocationService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("location not found with ID: " + id));
    }

    @Override
    @Transactional
    public Location save(Location location) {
        // Si Location tiene algún campo único, agrega validaciones aquí
        return locationRepository.save(location);
    }

    @Override
    @Transactional
    public Location update(Location location, Long id) {
        Location existingLocation = findById(id);
        // Aquí actualiza los campos que tenga Location, por ejemplo:
        existingLocation.setName(location.getName());
        existingLocation.setAddress(location.getAddress());
        // Agrega más según los atributos de Location
        return locationRepository.save(existingLocation);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Location location = findById(id);
        locationRepository.delete(location);
    }
}
