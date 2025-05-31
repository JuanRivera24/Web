package com.app.users.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.users.domain.IUserRepository;
import com.app.users.domain.IUserService;
import com.app.users.domain.User;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public User save(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("email registered: " + user.getEmail());
        }
        // Aquí podrías agregar validaciones para otros campos si quieres
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user, Long id) {
        User existingUser = findById(id);
        existingUser.setName(user.getName());
        existingUser.setLastname(user.getLastname());  // agregar atributo
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());        // agregar atributo
        existingUser.setRole(user.getRole());          // agregar atributo
        // Agrega más campos según tu tabla users si es necesario
        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
