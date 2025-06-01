package com.app.workinghours.application;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.workinghours.domain.IWorkingHourRepository;
import com.app.workinghours.domain.WorkingHour;

@Service
public class WorkingHoursDetailsServiceImpl implements UserDetailsService {

    private final IWorkingHourRepository workingHourRepository;

    public WorkingHoursDetailsServiceImpl(IWorkingHourRepository workingHourRepository) {
        this.workingHourRepository = workingHourRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String someIdentifier) throws UsernameNotFoundException {
        // Cambia el método para buscar WorkingHour según el identificador que tenga sentido
        WorkingHour workingHour = workingHourRepository.findBySomeIdentifier(someIdentifier)
                .orElseThrow(() -> new UsernameNotFoundException("WorkingHour not found with identifier: " + someIdentifier));

        // Aquí decides qué devolver para UserDetails. En caso que no se aplique a WorkingHour,
        // podrías lanzar excepción o retornar algún objeto custom si usas otro tipo de seguridad.

        return new org.springframework.security.core.userdetails.User(
                workingHour.getSomeProperty(),
                "N/A", // si no tiene password, o lo que sea adecuado
                new ArrayList<>());
    }
}
