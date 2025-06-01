package com.app.payments.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.payments.domain.IPaymentRepository;
import com.app.payments.domain.IPaymentService;
import com.app.payments.domain.Payment;

@Service
public class PaymentService implements IPaymentService {

    private final IPaymentRepository paymentRepository;

    public PaymentService(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("payment not found with ID: " + id));
    }

    @Override
    @Transactional
    public Payment save(Payment payment) {
        // Aquí puedes agregar validaciones específicas para Payment si quieres
        return paymentRepository.save(payment);
    }

    @Override
    @Transactional
    public Payment update(Payment payment, Long id) {
        Payment existingPayment = findById(id);
        // Actualiza los campos necesarios
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setMethod(payment.getMethod());
        existingPayment.setDate(payment.getDate());
        // etc.
        return paymentRepository.save(existingPayment);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Payment payment = findById(id);
        paymentRepository.delete(payment);
    }
}
