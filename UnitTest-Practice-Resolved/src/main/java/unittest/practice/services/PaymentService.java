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
        if (payment.getAmount() < 0) {
            throw new IllegalStateException("Payment should have positive amount.");
        }
        if (accountService.getAvailableAmount() < payment.getAmount()) {
            throw new IllegalStateException("Account without enough fundings for payment.");
        }

        accountService.debitFromAccount(payment.getAmount());
    }

    public Collection<Payment> getRegisteredPayments() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
