package com.bridgelabz;

public class CabInvoice {
    static final int COST_PER_KM = 10;
    static final int COST_PER_MIN = 1;
    static final int MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double cost = COST_PER_KM * distance + COST_PER_MIN * time;
        return (cost < MINIMUM_FARE) ? MINIMUM_FARE : cost;
    }

    public double calculateFare(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride : rides) {
            double totalFare = calculateFare(ride.distance, ride.time);
            aggregateFare += totalFare;
        }
        return aggregateFare;
    }

    public Invoice generateInvoice(Ride[] rides) {
        int totalRides = rides.length;
        double totalFare = calculateFare(rides);
        double avgFare = totalFare / totalRides;
        Invoice invoice = new Invoice(totalRides, totalFare, avgFare);
        return invoice;
    }

    public Invoice generateInvoice(int userId) {
        int totalRides = RideRepository.creatingUsers();
        Ride[] listOfRides = RideRepository.users.get(userId);
        double totalFare = calculateFare(listOfRides);
        double avgFare = totalFare / totalRides;
        Invoice invoice = new Invoice(totalRides, totalFare, avgFare);
        return invoice;
    }
}
