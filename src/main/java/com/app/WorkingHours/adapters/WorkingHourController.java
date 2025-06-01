package com.app.workinghours.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.workinghours.domain.IWorkingHourService;
import com.app.workinghours.domain.WorkingHour;

@RestController
@RequestMapping("/api/workinghours")
public class WorkingHourController {

    private final IWorkingHourService workingHourService;

    public WorkingHourController(IWorkingHourService workingHourService) {
        this.workingHourService = workingHourService;
    }

    // Obtener todas las working hours
    @GetMapping
    public ResponseEntity<List<WorkingHour>> getAllWorkingHours() {
        List<WorkingHour> workingHours = workingHourService.findAll();
        return ResponseEntity.ok(workingHours);
    }

    // Obtener working hour por ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkingHour> getWorkingHourById(@PathVariable Long id) {
        WorkingHour workingHour = workingHourService.findById(id);
        return ResponseEntity.ok(workingHour);
    }

    // Crear una nueva working hour
    @PostMapping
    public ResponseEntity<WorkingHour> createWorkingHour(@RequestBody WorkingHour workingHour) {
        WorkingHour newWorkingHour = workingHourService.save(workingHour);
        return ResponseEntity.ok(newWorkingHour);
    }

    // Actualizar working hour existente
    @PutMapping("/{id}")
    public ResponseEntity<WorkingHour> updateWorkingHour(@PathVariable Long id, @RequestBody WorkingHour workingHour) {
        WorkingHour updatedWorkingHour = workingHourService.update(workingHour, id);
        return ResponseEntity.ok(updatedWorkingHour);
    }

    // Eliminar working hour por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkingHour(@PathVariable Long id) {
        workingHourService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
