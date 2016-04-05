package com.scrumtrek.simplestore;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;

public class CustomerReqularTest {
	private static String cn;
	private static String mn;
	private static Movie m;
	private static Rental r;
	private static Customer c;
	
	@Before
	public void beforeTest () {
		cn = "Customer";
		mn = "XXX Film";
		m = new Movie(mn, PriceCodes.XXXPriceCode);
		r = new Rental(m, 7);
		c = new Customer(cn);
		c.addRental(r);
	}

	@Test
	public void runTestStatementString () {
		String en = "Rental record for " + cn + "\n" + 
				    "\t" + mn + "\t8.5" + "\n" + 
				    "Amount owed is 8.5";	
		String stmt = c.StatementString();
		
		System.out.println(stmt);
		Assert.assertNotNull(stmt);
		Assert.assertEquals(en, stmt);
	}
	
	@Test
	public void runTestStatement () {
		List<StatementRental> l = new ArrayList<StatementRental>();
		l = c.Statement();

		Assert.assertEquals(mn, l.get(0).getMovie().getTitle());
		Assert.assertEquals(8.5d, l.get(0).getAmount(), 0d);
	}
}
