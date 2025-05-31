package com.app.locations.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.locations.domain.ILocationRepository;
import com.app.locations.domain.Location;

@Component
public class LocationDatasource {

    private final ILocationRepository locationRepository;

    public LocationDatasource(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    public Location save(Location location) {
        return locationRepository.save(location);
    }

    public Optional<Location> update(Location location, Long id) {
        return locationRepository.findById(id).map(existingLocation -> {
            existingLocation.setName(location.getName());
            existingLocation.setAddress(location.getAddress());
            existingLocation.setPhone(location.getPhone());
            return locationRepository.save(existingLocation);
        });
    }

    public boolean deleteById(Long id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
