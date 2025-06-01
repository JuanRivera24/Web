package com.app.payments.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

    // Get all payments (already provided by JpaRepository)
    @Override
    @NonNull
    List<Payment> findAll();

    // Search payment by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Payment> findById(@NonNull Long id);

    // Save a payment (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Payment> S save(@NonNull S payment);

    // Check if a payment with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete payment by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Puedes agregar métodos específicos para pagos si los necesitas
}
