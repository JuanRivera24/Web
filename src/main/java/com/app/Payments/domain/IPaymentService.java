package com.app.payments.domain;

import java.util.List;

public interface IPaymentService {
    
    List<Payment> findAll();

    Payment findById(Long id);

    Payment save(Payment payment);

    Payment update(Payment payment, Long id);

    void deleteById(Long id);
}
