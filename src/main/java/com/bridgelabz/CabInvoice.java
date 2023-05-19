package com.bridgelabz;

public class CabInvoice {

    enum RideTypes{

        NORMALRIDES(10,1,5), PREMIUMRIDES(15,2,20);
        int COST_PER_KM;
        int COST_PER_MIN;
        int MINIMUM_FARE;

        RideTypes(int COST_PER_KM, int COST_PER_MIN, int MINIMUM_FARE) {
            this.COST_PER_KM = COST_PER_KM;
            this.COST_PER_MIN = COST_PER_MIN;
            this.MINIMUM_FARE = MINIMUM_FARE;
        }

        int getCOST_PER_KM(){
            return COST_PER_KM;
        }

        int getCOST_PER_MIN(){
            return COST_PER_MIN;
        }

        int getMINIMUM_FARE(){
            return MINIMUM_FARE;
        }

    }

    static final int COST_PER_KM = 10;
    static final int COST_PER_MIN = 1;
    static final int MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double cost = COST_PER_KM * distance + COST_PER_MIN * time;
        return (cost < MINIMUM_FARE) ? MINIMUM_FARE : cost;
    }

    public double calculateFare(double distance, int time, String RideType) {
        double cost;
        if (RideType.equals("Normal Rides")) {
            cost = RideTypes.NORMALRIDES.getCOST_PER_KM() * distance + RideTypes.NORMALRIDES.COST_PER_MIN * time;
            return (cost < RideTypes.NORMALRIDES.MINIMUM_FARE) ? RideTypes.NORMALRIDES.MINIMUM_FARE : cost;
        }else {
            cost = RideTypes.PREMIUMRIDES.getCOST_PER_KM() * distance + RideTypes.PREMIUMRIDES.COST_PER_MIN * time;
            return (cost < RideTypes.PREMIUMRIDES.MINIMUM_FARE) ? RideTypes.PREMIUMRIDES.MINIMUM_FARE : cost;
        }
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
