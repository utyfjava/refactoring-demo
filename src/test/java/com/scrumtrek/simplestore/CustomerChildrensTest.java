package com.scrumtrek.simplestore;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import com.scrumtrek.simplestore.StatementRental;

public class CustomerChildrensTest {

	@Test
	public void runTestStatementString () {
		String cn = "Customer";
		String mn = "Childrens Film";
		String en = "Rental record for " + cn + "\n" + 
				    "\t" + mn + "\t6.0" + "\n" + 
				    "Amount owed is 6.0" + "\n" +
		 			"You earned 1 frequent renter points.";	
		
		Movie m = new Movie(mn, PriceCodes.Childrens);
		Rental r = new Rental(m, 7);
		Customer c = new Customer(cn);
		c.addRental(r);
		String stmt = c.StatementString();
		
		Assert.assertNotNull(stmt);
		Assert.assertEquals(en, stmt);
	}
	
	//	@Test
	//	public void runTestStatement () {
	//		String cn = "Customer";
	//		String mn = "Childrens Film";
	//		List<StatementRental> l = new ArrayList<StatementRental>();
	//		
	//		Movie m = new Movie(mn, PriceCodes.Childrens);
	//		Rental r = new Rental(m, 7);
	//		Customer c = new Customer(cn);
	//		c.addRental(r);
	//		
	//		l = c.Statement();
	//		
	//		Assert.assertEquals(mn, l.get(1).getMovie().getTitle());
	//	}
}
