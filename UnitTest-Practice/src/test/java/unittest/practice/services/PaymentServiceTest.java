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

    @Test
    public void registerPayment_WithNegativeAmount_ShouldFailWithException() {
        //TODO: Implement
    }

    @Test
    public void registerPayment_WithPositiveAmountAndAccountFundingsInsufficient_ShouldFailWithException() {
        //TODO: Implement
    }

}
