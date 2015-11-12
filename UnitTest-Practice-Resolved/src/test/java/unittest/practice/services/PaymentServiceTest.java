package unittest.practice.services;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import unittest.practice.entities.Payment;

/**
 * Payment service unit tests.
 *
 * @author Marcelo Busico.
 */
public class PaymentServiceTest {

    public PaymentServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void registerPayment_WithPositiveAmountAndEnoughAccountFundings_ShouldRegisterPayment() {
        //Setup
        AccountService accountService = new AccountService(20f);
        PaymentService paymentService = new PaymentService(accountService);
        Payment payment1 = new Payment("Test Payment 1", 10f);
        Payment payment2 = new Payment("Test Payment 2", 5f);

        //Test
        paymentService.registerPayment(payment1);

        //Verify
        assertEquals("Available amount was not updated after registering payment 1.",
                10.f, accountService.getAvailableAmount(), 0.01f);

        //Test
        paymentService.registerPayment(payment2);

        //Verify
        assertEquals("Available amount was not updated after registering payment 2.",
                5.f, accountService.getAvailableAmount(), 0.01f);
    }

    @Test
    public void registerPayment_WithNegativeAmount_ShouldFailWithException() {
        //Setup
        AccountService accountService = new AccountService(20f);
        PaymentService paymentService = new PaymentService(accountService);
        Payment payment = new Payment("Test Payment", -15f);

        //Test
        try {
            paymentService.registerPayment(payment);
            fail("Exception for invalid amount should be thrown here.");
        } catch (IllegalStateException ex) {
            //Verify
            assertEquals("Unexpected exception message for invalid payment.",
                    "Payment should have positive amount.", ex.getMessage());
        }
    }

    @Test
    public void registerPayment_WithPositiveAmountAndAccountFundingsInsufficient_ShouldFailWithException() {
        //Setup
        AccountService accountService = new AccountService(20f);
        PaymentService paymentService = new PaymentService(accountService);
        Payment payment = new Payment("Test Payment", 25f);

        //Test
        try {
            paymentService.registerPayment(payment);
            fail("Exception for invalid amount should be thrown here.");
        } catch (IllegalStateException ex) {
            //Verify
            assertEquals("Unexpected exception message for invalid payment.",
                    "Account without enough fundings for payment.", ex.getMessage());
        }
    }
}
