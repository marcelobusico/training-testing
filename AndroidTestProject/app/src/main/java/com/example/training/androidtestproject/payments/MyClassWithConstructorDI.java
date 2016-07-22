package com.example.training.androidtestproject.payments;

public class MyClassWithConstructorDI {

    private final PaymentService paymentService;

    public MyClassWithConstructorDI(PaymentService paymentService) {
        if (paymentService == null) {
            throw new IllegalArgumentException("Argument paymentService null.");
        }

        this.paymentService = paymentService;
    }

    public void verifyAndRegisterPayment(Payment payment) {
        if (payment != null) {
            paymentService.registerPayment(payment);
        }
    }
}

