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

public class CustomerXXXTest {
	private static String cn;
	private static String mn;
	private static Movie m;
	private static Rental r;
	private static Customer c;
	
	@Before
	public void beforeTest () {
		cn = "Customer";
		mn = "Regular Film";
		m = new Movie(mn, PriceCodes.Regular);
		r = new Rental(m, 7);
		c = new Customer(cn);
		c.addRental(r);
	}

	@Test
	public void runTestStatementString () {
		String en = "Rental record for " + cn + "\n" + 
				    "\t" + mn + "\t9.5" + "\n" + 
				    "Amount owed is 9.5";	
		String stmt = c.StatementString();
		Assert.assertNotNull(stmt);
		Assert.assertEquals(en, stmt);
	}
	
	@Test
	public void runTestStatementJson () {
		String stmt = c.StatementJson();
		Assert.assertNotNull(stmt);
		Assert.assertEquals(stmt.contains(cn), true);
	}
	
	@Test
	public void runTestStatement () {
		List<StatementRental> l = new ArrayList<StatementRental>();
		l = c.Statement();

		Assert.assertEquals(mn, l.get(0).getMovie().getTitle());
		Assert.assertEquals(9.5d, l.get(0).getAmount(), 0d);
	}
}
