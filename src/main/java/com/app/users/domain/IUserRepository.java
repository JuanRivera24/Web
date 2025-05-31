package com.app.users.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Override
    @NonNull
    List<User> findAll();

    @Override
    @NonNull
    Optional<User> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends User> S save(@NonNull S user);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    // Buscar usuario por email
    Optional<User> findByEmail(String email);

    // Verificar si un email ya está registrado
    boolean existsByEmail(String email);

    // Buscar usuario por nombre
    List<User> findByName(String name);

    // Buscar usuario por apellido
    List<User> findByLastname(String lastname);

    // Buscar usuario por teléfono
    List<User> findByPhone(String phone);

    // Buscar usuarios por rol (por ejemplo ROLE_USER o ROLE_ADMIN)
    List<User> findByRole(String role);
}
