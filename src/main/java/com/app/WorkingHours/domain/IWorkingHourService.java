package com.app.workinghours.domain;

import java.util.List;

public interface IWorkingHourService {
    
    List<WorkingHour> findAll();

    WorkingHour findById(Long id);

    WorkingHour save(WorkingHour workingHour);

    WorkingHour update(WorkingHour workingHour, Long id);

    void deleteById(Long id);
}
