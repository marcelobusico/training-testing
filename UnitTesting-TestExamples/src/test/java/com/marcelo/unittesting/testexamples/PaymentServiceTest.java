package com.marcelo.unittesting.testexamples;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.easymock.EasyMock;
import org.mockito.Mockito;

public class PaymentServiceTest {

    private PaymentService paymentService;

    @BeforeClass
    public static void setUpClass() {
        StorageServiceFactory.setStorageService(new InMemoryStorageService());
    }

    @AfterClass
    public static void tearDownClass() {
        StorageServiceFactory.useDefaultStorageService();
    }

    @Before
    public void setUp() {
        StorageService storageService = new InMemoryStorageService();
        StorageServiceFactory.setStorageService(storageService);
        paymentService = new PaymentService(storageService);
    }

    @After
    public void tearDown() {
        paymentService.dispose();
    }

    @Test
    public void comingSoonTest() {
    }

    @Test
    public void registerPayment_validPaymentData_shouldRegisterPayment() {
        //Setup
        Payment payment = new Payment(50);

        //Test
        paymentService.registerPayment(payment);

        //Verify
        List<Payment> storedPayments = StorageServiceFactory.getStorageService().loadObjects();
        assertEquals("Unexpected number of stored payments.", 1, storedPayments.size());
        Payment storedPayment = storedPayments.get(0);
        assertEquals("Stored payment not equals to original payment.", payment, storedPayment);
    }

    @Test
    public void getPayments_oneRegisteredPayment_shouldReturnListWithRegisteredPayment() {
        //Setup
        Payment payment = new Payment(50);
        StorageService storageService = StorageServiceFactory.getStorageService();
        storageService.saveObject(payment);

        //Test
        List<Payment> payments = paymentService.getPayments();

        //Verify
        assertNotNull("getPayments result should not be null.", payments);
        assertEquals("getPayments with invalid amount of payments.", 1, payments.size());
        assertEquals("getPayments did not retrieve previously stored payment.", payment, payments.get(0));
    }

    @Test
    public void registerPayment_validPaymentData_shouldCallPaymentGatewayWithPaymentData_usingMockito() {
        //Setup - Data
        Payment payment = new Payment(50);
        StorageService mockStorageService = Mockito.mock(StorageService.class);
        PaymentService testPaymentService = new PaymentService(mockStorageService);

        //Test
        testPaymentService.registerPayment(payment);

        //Verify Behavior
        Mockito.verify(mockStorageService, Mockito.times(1)).saveObject(payment);
    }

    @Test
    public void registerPayment_validPaymentData_shouldCallPaymentGatewayWithPaymentData_usingEasyMock() {
        //Setup - Data
        Payment payment = new Payment(50);
        StorageService mockStorageService = EasyMock.createMock(StorageService.class);
        PaymentService testPaymentService = new PaymentService(mockStorageService);

        //Setup - Expectations
        mockStorageService.saveObject(payment);
        EasyMock.expectLastCall();
        EasyMock.replay(mockStorageService);

        //Test
        testPaymentService.registerPayment(payment);

        //Verify
        EasyMock.verify(mockStorageService);
    }

}
