package com.app.locations.domain;

import java.util.List;

public interface ILocationService {
    
    List<Location> findAll();

    Location findById(Long id);

    Location save(Location location);

    Location update(Location location, Long id);

    void deleteById(Long id);
}
