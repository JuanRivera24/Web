package com.app.appointments.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long barberId;

    @Column(nullable = false)
    private Long serviceId;

    @Column(nullable = false)
    private Long locationId;

    @Column(nullable = false)
    private String status;

    // Empty constructor (required for JPA)
    public Appointment() {}

    // Constructor with parameters
    public Appointment(Long id, LocalDateTime appointmentDate, Long userId, Long barberId, Long serviceId, Long locationId, String status) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.userId = userId;
        this.barberId = barberId;
        this.serviceId = serviceId;
        this.locationId = locationId;
        this.status = status;
    }

    // Getters and Setters (opcional si usas Lombok)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
