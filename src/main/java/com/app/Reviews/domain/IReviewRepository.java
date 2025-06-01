package com.app.reviews.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Long> {

    @Override
    @NonNull
    List<Review> findAll();

    @Override
    @NonNull
    Optional<Review> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends Review> S save(@NonNull S review);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    // Métodos extra que podrían ser útiles según la base de datos

    // Obtener reseñas por usuario (user_id en la tabla)
    List<Review> findByUserId(Long userId);

    // Obtener reseñas por servicio (service_id en la tabla)
    List<Review> findByServiceId(Long serviceId);
}
