package com.app.payments.application;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.payments.domain.IPaymentRepository;
import com.app.payments.domain.Payment;

@Service
public class PaymentDetailsServiceImpl implements UserDetailsService {

    private final IPaymentRepository paymentRepository;

    public PaymentDetailsServiceImpl(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String paymentReference) throws UsernameNotFoundException {
        Payment payment = paymentRepository.findByReference(paymentReference)
                .orElseThrow(() -> new UsernameNotFoundException("Payment not found with reference: " + paymentReference));

        // Aquí devolvemos un UserDetails de Spring Security solo a modo de ejemplo
        return new org.springframework.security.core.userdetails.User(
                payment.getReference(),
                "", // No hay password para un pago
                new ArrayList<>());
    }
}
