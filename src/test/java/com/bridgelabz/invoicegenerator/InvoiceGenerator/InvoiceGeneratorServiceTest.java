package com.bridgelabz.invoicegenerator.InvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorServiceTest {
	InvoiceGenerator invoicegenerator = null;
	
	@Before
	public void initialization() {
		invoicegenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {

		double distance = 2.0;
		int time = 5;
		double fare = invoicegenerator.calculateFare( distance, time);
		Assert.assertEquals(25, fare, 0.0);	
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoicegenerator.calculateFare( distance, time);
		Assert.assertEquals(5, fare ,  0.0);

	}

//	@Test
//	public void givenMultipleRides_ShouldReturnToatalFareForAllRides() {
//		MultipleRides[] rides = { new MultipleRides(2.0, 5),
//				new MultipleRides(0.1, 1)
//		};
//		double fare = invoicegenerator.calculateFare(rides) ;
//		Assert.assertEquals(30,fare, 0.0);
//	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		MultipleRides[] rides = { new MultipleRides(2.0, 5),
				new MultipleRides(0.1, 1)
		};
		InvoiceSummary summary = invoicegenerator.calculateFare(rides) ;
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary,summary);
	}
	
	
}
