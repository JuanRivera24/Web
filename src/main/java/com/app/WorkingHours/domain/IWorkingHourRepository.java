package com.app.workinghours.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorkingHourRepository extends JpaRepository<WorkingHour, Long> {

    // Get all working hours (already provided by JpaRepository)
    @Override
    @NonNull
    List<WorkingHour> findAll();

    // Search working hour by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<WorkingHour> findById(@NonNull Long id);

    // Save a working hour (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends WorkingHour> S save(@NonNull S workingHour);

    // Check if a working hour with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete working hour by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

}
