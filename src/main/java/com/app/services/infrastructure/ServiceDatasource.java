package com.app.services.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.services.domain.IServiceRepository;
import com.app.services.domain.Service;

@Component
public class ServiceDatasource {

    private final IServiceRepository serviceRepository;

    public ServiceDatasource(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    public Optional<Service> findById(Long id) {
        return serviceRepository.findById(id);
    }

    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    public Optional<Service> update(Service service, Long id) {
        return serviceRepository.findById(id).map(existingService -> {
            existingService.setName(service.getName());
            existingService.setEmail(service.getEmail());
            return serviceRepository.save(existingService);
        });
    }

    public boolean deleteById(Long id) {
        if (serviceRepository.existsById(id)) {
            serviceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
