package com.app.services.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.services.domain.IServiceService;
import com.app.services.domain.Service;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final IServiceService serviceService;

    public ServiceController(IServiceService serviceService) {
        this.serviceService = serviceService;
    }

    // all services
    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceService.findAll();
        return ResponseEntity.ok(services);
    }

    // service by id
    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        Service service = serviceService.findById(id);
        return ResponseEntity.ok(service);
    }

    // create service
    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service newService = serviceService.save(service);
        return ResponseEntity.ok(newService);
    }

    // update service
    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Long id, @RequestBody Service service) {
        Service updatedService = serviceService.update(service, id);
        return ResponseEntity.ok(updatedService);
    }

    // delete service
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
