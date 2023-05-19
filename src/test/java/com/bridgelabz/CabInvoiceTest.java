package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

public class CabInvoiceTest {
    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double actualCost = cabInvoice.calculateFare(5, 30);

        Assertions.assertEquals(80, actualCost);
    }

    @Test
    public void givenDistanceAndTimeShouldReturnMinimumFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double actualCost = cabInvoice.calculateFare(0.2, 2);

        Assertions.assertEquals(5, actualCost);
    }

    @Test
    public void givenMultipleRidesShouldReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        Ride[] rides = {new Ride(5, 30), new Ride(10, 20), new Ride(15, 40)};
        double actualCost = cabInvoice.calculateFare(rides);
        Assertions.assertEquals(390, actualCost);

    }

    @Test
    public void givenMultipleRidesShouldReturnEnhancedInvoice() {
        CabInvoice cabInvoice = new CabInvoice();
        Ride[] rides = {new Ride(5, 30), new Ride(10, 20), new Ride(15, 40)};
        Invoice invoice = cabInvoice.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(3, 390, 130);
        Assertions.assertEquals(expectedInvoice, invoice);
    }

    @Test
    public void givenUserIdInvoiceGeneratorGetsRideRepositoryShouldReturnInvoice() {
        CabInvoice cabInvoice = new CabInvoice();
        int userId = 1;
        Invoice invoice = cabInvoice.generateInvoice(userId);
        Invoice expectedInvoice = new Invoice(3, 390, 130);
        Assertions.assertEquals(expectedInvoice, invoice);
    }

    @Test
    public void givenDistance_TimeAndRideTypeShouldReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double actualCost = cabInvoice.calculateFare(5, 30,"Normal Rides");
        Assertions.assertEquals(80, actualCost);
    }

    @Test
    public void givenDistance_TimeAndRideType1ShouldReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double actualCost = cabInvoice.calculateFare(5, 30,"Premium Rides");
        Assertions.assertEquals(135, actualCost);
    }

}



