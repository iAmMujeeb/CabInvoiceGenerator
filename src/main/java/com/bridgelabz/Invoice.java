package com.bridgelabz;

import java.util.Objects;

public class Invoice {
    int totalRides;
    double totalFare;
    double avgFare;

    public Invoice(int totalRides, double totalFare, double avgFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.avgFare = avgFare;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice invoice)) return false;
        return totalRides == invoice.totalRides && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.avgFare, avgFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRides, totalFare, avgFare);
    }
}
