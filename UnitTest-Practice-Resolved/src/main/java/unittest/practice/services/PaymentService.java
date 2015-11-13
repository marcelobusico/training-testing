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
        if (accountService == null) {
            throw new IllegalArgumentException("AccountService null.");
        }
        this.accountService = accountService;
    }

    public void registerPayment(Payment payment) {
        if (payment != null) {
            if (payment.getAmount() < 0) {
                throw new IllegalArgumentException("Invalid payment amount.");
            }

            if (accountService.getAvailableAmount() < payment.getAmount()) {
                throw new IllegalStateException("Insufficient account foundings.");
            }

            accountService.debitFromAccount(payment.getAmount());
        }
    }

    public Collection<Payment> getRegisteredPayments() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
