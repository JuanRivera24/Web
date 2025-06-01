package com.app.users.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.users.domain.IWorkingHourRepository;
import com.app.users.domain.WorkingHour;

@Component
public class WorkingHourDatasource {

    private final IWorkingHourRepository workingHourRepository;

    public WorkingHourDatasource(IWorkingHourRepository workingHourRepository) {
        this.workingHourRepository = workingHourRepository;
    }

    public List<WorkingHour> findAll() {
        return workingHourRepository.findAll();
    }

    public Optional<WorkingHour> findById(Long id) {
        return workingHourRepository.findById(id);
    }

    public WorkingHour save(WorkingHour workingHour) {
        return workingHourRepository.save(workingHour);
    }

    public Optional<WorkingHour> update(WorkingHour workingHour, Long id) {
        return workingHourRepository.findById(id).map(existingWorkingHour -> {
            existingWorkingHour.setDayOfWeek(workingHour.getDayOfWeek());
            existingWorkingHour.setStartTime(workingHour.getStartTime());
            existingWorkingHour.setEndTime(workingHour.getEndTime());
            existingWorkingHour.setBarber(workingHour.getBarber());
            return workingHourRepository.save(existingWorkingHour);
        });
    }

    public boolean deleteById(Long id) {
        if (workingHourRepository.existsById(id)) {
            workingHourRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
