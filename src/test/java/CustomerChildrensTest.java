import org.junit.Assert;
import org.junit.Test;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;

public class CustomerChildrensTest {

	@Test
	public void runTest () {
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
		String stmt = c.Statement();
		
		Assert.assertNotNull(stmt);
		Assert.assertEquals(stmt, en);
	}
}
