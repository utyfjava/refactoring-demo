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
	
	public void beforeTest (int days) {
		cn = "Customer";
		mn = "XXX Film";
		m = new Movie(mn, PriceCodes.XXXPriceCode);
		r = new Rental(m, days);
		c = new Customer(cn);
		c.addRental(r);
	}

	@Test
	public void runTestStatementString () {
		beforeTest(7);
		String en = "Rental record for " + cn + "\n" + 
				    "\t" + mn + "\t8.5" + "\n" + 
				    "Amount owed is 8.5";	
		String stmt = c.StatementString();
		
		Assert.assertNotNull(stmt);
		Assert.assertEquals(en, stmt);
	}
	
	@Test
	public void runTestStatementJson () {
		beforeTest(7);
		String stmt = c.StatementJson();
		Assert.assertNotNull(stmt);
		Assert.assertEquals(stmt.contains(cn), true);
	}
	
	@Test
	public void runTestStatement () {
		beforeTest(7);
		List<StatementRental> l = new ArrayList<StatementRental>();
		l = c.Statement();

		Assert.assertEquals(mn, l.get(0).getMovie().getTitle());
		Assert.assertEquals(8.5d, l.get(0).getAmount(), 0d);
	}
	
	@Test
	public void runTestStatement1 () {
		beforeTest(1);
		List<StatementRental> l = new ArrayList<StatementRental>();
		l = c.Statement();

		Assert.assertEquals(mn, l.get(0).getMovie().getTitle());
//		Assert.assertEquals(2.0d, l.get(0).getAmount(), 0d);
	}
}
