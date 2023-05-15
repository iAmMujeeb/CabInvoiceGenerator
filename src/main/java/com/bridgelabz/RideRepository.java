package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;

public class RideRepository {

    static HashMap<Integer, Ride[]> users = new HashMap<>();

    public static int creatingUsers() {
        Ride[] ride = {new Ride(5, 30), new Ride(10, 20), new Ride(15, 40)};//390
//        Ride[] ride1 = {new Ride(6, 31), new Ride(11, 21), new Ride(16, 41)};//423
//        Ride[] ride2 = {new Ride(7, 32), new Ride(12, 22), new Ride(17, 42)};//456 = 1269
        int totalRides = ride.length;
        users.put(1, ride);
        users.put(2, ride);
        users.put(3, ride);
        return totalRides;
    }

}
