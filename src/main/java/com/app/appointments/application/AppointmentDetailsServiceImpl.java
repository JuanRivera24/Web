package com.app.appointments.application;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.appointments.domain.IAppointmentRepository;
import com.app.appointments.domain.Appointment;

@Service
public class AppointmentDetailsServiceImpl implements UserDetailsService {

    private final IAppointmentRepository appointmentRepository;

    public AppointmentDetailsServiceImpl(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String referenceCode) throws UsernameNotFoundException {
        Appointment appointment = appointmentRepository.findByReferenceCode(referenceCode)
                .orElseThrow(() -> new UsernameNotFoundException("Appointment not found with reference: " + referenceCode));

        return new org.springframework.security.core.userdetails.User(
                appointment.getReferenceCode(),
                appointment.getSecretCode(), // o similar
                new ArrayList<>());
    }
}
