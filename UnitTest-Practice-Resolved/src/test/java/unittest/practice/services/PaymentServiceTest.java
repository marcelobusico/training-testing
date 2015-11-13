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
        Payment payment = new Payment("Test Payment", 15f);

        //Test
        paymentService.registerPayment(payment);

        //Verify
        assertEquals("Available amount was not updated after registering payment.",
                5.f, accountService.getAvailableAmount(), 0.01f);
    }

    @Test()
    public void registerPayment_WithNegativeAmount_ShouldFailWithException() {
        //Setup
        AccountService accountService = new AccountService(20f);
        PaymentService paymentService = new PaymentService(accountService);
        Payment payment = new Payment("Test Payment", -15f);

        //Test
        try {
            paymentService.registerPayment(payment);
            fail("Exception should be thrown.");
        } catch (IllegalArgumentException ex) {
            assertEquals("Exception message invalid.",
                    "Invalid payment amount.", ex.getMessage());
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
            fail("Exception should be thrown.");
        } catch (IllegalStateException ex) {
            assertEquals("Exception message invalid.",
                    "Insufficient account foundings.", ex.getMessage());
        }
    }

    @Test
    public void registerPayment_WithNullPayment_ShouldIgnorePayment() {
        //Setup
        AccountService accountService = new AccountService(20f);
        PaymentService paymentService = new PaymentService(accountService);
        Payment payment = null;

        //Test
        paymentService.registerPayment(payment);

        //Verify
        assertEquals("Available amount was updated after registering null payment.",
                20.f, accountService.getAvailableAmount(), 0.01f);
    }

    @Test
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void paymentService_withNullAccountService_ShouldFailConstruction() {
        //Test
        try {
            new PaymentService(null);
            fail("Exception should be thrown.");
        } catch (IllegalArgumentException ex) {
            assertEquals("Exception message invalid.",
                    "AccountService null.", ex.getMessage());
        }
    }

}
