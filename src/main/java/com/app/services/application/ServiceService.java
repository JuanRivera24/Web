package com.app.services.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.services.domain.IServiceRepository;
import com.app.services.domain.IServiceService;
import com.app.services.domain.Service;

@Service
public class ServiceService implements IServiceService {

    private final IServiceRepository serviceRepository;

    public ServiceService(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("service not found with ID: " + id));
    }

    @Override
    @Transactional
    public Service save(Service service) {
        if (serviceRepository.existsByEmail(service.getEmail())) {
            throw new IllegalArgumentException("email registered: " + service.getEmail());
        }
        return serviceRepository.save(service);
    }

    @Override
    @Transactional
    public Service update(Service service, Long id) {
        Service existingService = findById(id);
        existingService.setName(service.getName());
        existingService.setEmail(service.getEmail());
        return serviceRepository.save(existingService);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Service service = findById(id);
        serviceRepository.delete(service);
    }
}
