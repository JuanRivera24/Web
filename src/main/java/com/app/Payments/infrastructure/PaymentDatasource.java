package com.app.payments.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.payments.domain.IPaymentRepository;
import com.app.payments.domain.Payment;

@Component
public class PaymentDatasource {

    private final IPaymentRepository paymentRepository;

    public PaymentDatasource(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> update(Payment payment, Long id) {
        return paymentRepository.findById(id).map(existingPayment -> {
            existingPayment.setAppointmentId(payment.getAppointmentId());
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setPaymentMethod(payment.getPaymentMethod());
            existingPayment.setPaymentDate(payment.getPaymentDate());
            return paymentRepository.save(existingPayment);
        });
    }

    public boolean deleteById(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
