package com.app.services.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.services.domain.IServiceRepository;
import com.app.services.domain.IServiceService;
import com.app.services.domain.ServiceEntity;  // Asumiendo que tu entidad se llama ServiceEntity

@Service
public class ServiceService implements IServiceService {

    private final IServiceRepository serviceRepository;

    public ServiceService(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServiceEntity> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceEntity findById(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + id));
    }

    @Override
    @Transactional
    public ServiceEntity save(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    @Override
    @Transactional
    public ServiceEntity update(ServiceEntity service, Long id) {
        ServiceEntity existingService = findById(id);
        existingService.setName(service.getName());
        existingService.setPrice(service.getPrice());
        existingService.setDescription(service.getDescription());
        // Actualiza más campos si tienes
        return serviceRepository.save(existingService);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        ServiceEntity service = findById(id);
        serviceRepository.delete(service);
    }
}
