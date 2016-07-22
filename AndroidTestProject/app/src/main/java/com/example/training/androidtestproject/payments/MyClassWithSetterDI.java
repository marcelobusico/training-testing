package com.example.training.androidtestproject.payments;

public class MyClassWithSetterDI {

    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void verifyAndRegisterPayment(Payment payment) {
        verifyPaymentServiceIsInitialized();

        if (payment != null) {
            paymentService.registerPayment(payment);
        }
    }

    private void verifyPaymentServiceIsInitialized() {
        if (paymentService == null) {
            throw new IllegalStateException("paymentService not yet initialized.");
        }
    }
}
