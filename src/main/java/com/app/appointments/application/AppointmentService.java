package com.app.appointments.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.appointments.domain.IAppointmentRepository;
import com.app.appointments.domain.IAppointmentService;
import com.app.appointments.domain.Appointment;

@Service
public class AppointmentService implements IAppointmentService {

    private final IAppointmentRepository appointmentRepository;

    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + id));
    }

    @Override
    @Transactional
    public Appointment save(Appointment appointment) {
        // Aquí podrías validar si hay conflictos de horario, barbería o usuario
        return appointmentRepository.save(appointment);
    }

    @Override
    @Transactional
    public Appointment update(Appointment appointment, Long id) {
        Appointment existingAppointment = findById(id);
        existingAppointment.setDate(appointment.getDate());
        existingAppointment.setTime(appointment.getTime());
        existingAppointment.setUser(appointment.getUser());
        existingAppointment.setService(appointment.getService());
        existingAppointment.setLocation(appointment.getLocation());
        return appointmentRepository.save(existingAppointment);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Appointment appointment = findById(id);
        appointmentRepository.delete(appointment);
    }
}
