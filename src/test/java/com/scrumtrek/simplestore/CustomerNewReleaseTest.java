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

public class CustomerNewReleaseTest {
	private static String cn;
	private static String mn;
	private static Movie m;
	private static Rental r;
	private static Customer c;
	
	public void beforeTest (int days) {
		cn = "Customer";
		mn = "NewRelease Film";
		m = new Movie(mn, PriceCodes.NewRelease);
		r = new Rental(m, days);
		c = new Customer(cn);
		c.addRental(r);
	}

	@Test
	public void runTestStatementString () {
		beforeTest(7);
		String en = "Rental record for " + cn + "\n" + 
				    "\t" + mn + "\t21.0" + "\n" + 
				    "Amount owed is 21.0";	
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
		Assert.assertEquals(21.0d, l.get(0).getAmount(), 0d);
	}
}
