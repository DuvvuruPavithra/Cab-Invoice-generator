package com.bridgelabz.invoicegenerator.InvoiceGenerator;

public class InvoiceGenerator {
	private static final int TimePerCost = 1;
	private static final double CostPerKilometer = 10;

	private static final int MINIMUM_FARE = 5;


	public double calculateFare(double distance, int time) {
		double totalFare = distance * CostPerKilometer + time * TimePerCost;
		return Math.max(totalFare, MINIMUM_FARE);
	}


	public InvoiceSummary calculateFare(MultipleRides[] rides) {
		double totalFare = 0; 
		for	(MultipleRides ride:rides)	{
			totalFare += this.calculateFare(ride.distance,ride.time);
			System.out.println("distance "+ride.distance+"time"+ride.time);

		}
		return new InvoiceSummary(rides.length,totalFare);
	}
	
	

}
