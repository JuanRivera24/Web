package com.app.appointments.domain;

import java.util.List;

public interface IAppointmentService {

    List<Appointment> findAll();

    Appointment findById(Long id);

    Appointment save(Appointment appointment);

    Appointment update(Appointment appointment, Long id);

    void deleteById(Long id);
}
