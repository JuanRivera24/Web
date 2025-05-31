package com.app.locations.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {

    // Get all locations (already provided by JpaRepository)
    @Override
    @NonNull
    List<Location> findAll();

    // Search location by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Location> findById(@NonNull Long id);

    // Save a location (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Location> S save(@NonNull S location);

    // Check if a location with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete location by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Add additional domain-specific methods here if needed
    // Example:
    // Optional<Location> findByName(String name);
    // boolean existsByName(String name);
}
