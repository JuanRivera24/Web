package com.app.appointments.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    // Get all appointments (inherited from JpaRepository)
    @Override
    @NonNull
    List<Appointment> findAll();

    // Search appointment by ID (inherited from JpaRepository)
    @Override
    @NonNull
    Optional<Appointment> findById(@NonNull Long id);

    // Save an appointment (inherited from JpaRepository)
    @Override
    @NonNull
    <S extends Appointment> S save(@NonNull S appointment);

    // Check if an appointment with a specific ID exists (inherited from JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete appointment by ID (inherited from JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // You can add additional methods specific for Appointment if needed.
    // For example, find all appointments for a user:
    List<Appointment> findByUserId(Long userId);

    // Find all appointments for a specific barber:
    List<Appointment> findByBarberId(Long barberId);

    // Find appointments by status:
    List<Appointment> findByStatus(String status);
}
