package com.app.appointments.infrastructure;

import java.time.LocalDateTime;

public class AppointmentDto {
    private Long id;
    private LocalDateTime dateTime;
    private Long clientId;
    private Long serviceId;
    private String status;

    // Empty constructor
    public AppointmentDto() {
    }

    // Constructor with parameters
    public AppointmentDto(Long id, LocalDateTime dateTime, Long clientId, Long serviceId, String status) {
        this.id = id;
        this.dateTime = dateTime;
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.status = status;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString() method
    @Override
    public String toString() {
        return "AppointmentDto{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", clientId=" + clientId +
                ", serviceId=" + serviceId +
                ", status='" + status + '\'' +
                '}';
    }
}
