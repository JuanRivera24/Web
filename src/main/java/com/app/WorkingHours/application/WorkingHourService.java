package com.app.workinghours.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;
import com.app.workinghours.domain.IWorkingHourRepository;
import com.app.workinghours.domain.IWorkingHourService;
import com.app.workinghours.domain.WorkingHour;

@Service
public class WorkingHourService implements IWorkingHourService {

    private final IWorkingHourRepository workingHourRepository;

    public WorkingHourService(IWorkingHourRepository workingHourRepository) {
        this.workingHourRepository = workingHourRepository;
    }

    @Override
    public List<WorkingHour> findAll() {
        return workingHourRepository.findAll();
    }

    @Override
    public WorkingHour findById(Long id) {
        return workingHourRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("WorkingHour not found with ID: " + id));
    }

    @Override
    @Transactional
    public WorkingHour save(WorkingHour workingHour) {
        // Si tienes alguna regla de validación específica, agrégala aquí
        return workingHourRepository.save(workingHour);
    }

    @Override
    @Transactional
    public WorkingHour update(WorkingHour workingHour, Long id) {
        WorkingHour existingWorkingHour = findById(id);
        existingWorkingHour.setDayOfWeek(workingHour.getDayOfWeek());
        existingWorkingHour.setOpenTime(workingHour.getOpenTime());
        existingWorkingHour.setCloseTime(workingHour.getCloseTime());
        // Actualiza otros campos si tienes
        return workingHourRepository.save(existingWorkingHour);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        WorkingHour workingHour = findById(id);
        workingHourRepository.delete(workingHour);
    }
}
