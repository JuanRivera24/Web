package com.app.payments.infrastructure;

import java.time.LocalDateTime;

public class PaymentDto {
    private Long id;
    private Long appointmentId;
    private Double amount;
    private String paymentMethod;
    private LocalDateTime paymentDate;

    // Empty constructor
    public PaymentDto() {
    }

    // Constructor with parameters
    public PaymentDto(Long id, Long appointmentId, Double amount, String paymentMethod, LocalDateTime paymentDate) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    // toString() method
    @Override
    public String toString() {
        return "PaymentDto{" +
                "id=" + id +
                ", appointmentId=" + appointmentId +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
