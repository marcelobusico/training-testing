package unittest.practice.services;

import java.util.Collection;
import unittest.practice.entities.Payment;

/**
 * Payment Service.
 *
 * @author Marcelo Busico.
 */
public class PaymentService {
    
    private final AccountService accountService;

    public PaymentService(AccountService accountService) {
        this.accountService = accountService;
    }
    
    public void registerPayment(Payment payment) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public Collection<Payment> getRegisteredPayments() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
