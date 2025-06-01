package com.app.appointments.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.appointments.domain.IAppointmentRepository;
import com.app.appointments.domain.Appointment;

@Component
public class AppointmentDatasource {

    private final IAppointmentRepository appointmentRepository;

    public AppointmentDatasource(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> update(Appointment appointment, Long id) {
        return appointmentRepository.findById(id).map(existingAppointment -> {
            // Aquí actualizas los campos que tenga Appointment
            existingAppointment.setDate(appointment.getDate());
            existingAppointment.setClient(appointment.getClient());
            existingAppointment.setService(appointment.getService());
            existingAppointment.setStatus(appointment.getStatus());
            // Añade más campos según la entidad Appointment
            return appointmentRepository.save(existingAppointment);
        });
    }

    public boolean deleteById(Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
