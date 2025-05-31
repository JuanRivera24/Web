package com.app.services.domain;

import java.util.List;

public interface IServiceService {
    
    List<Service> findAll();

    Service findById(Long id);

    Service save(Service service);

    Service update(Service service, Long id);

    void deleteById(Long id);
}
