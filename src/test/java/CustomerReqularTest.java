import org.junit.Assert;
import org.junit.Test;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;

public class CustomerReqularTest {

	@Test
	public void runTest () {
		Movie m = new Movie("Regular Film", PriceCodes.Regular);
		Rental r = new Rental(m, 7);
		Customer c = new Customer("Customer");
		c.addRental(r);
		String stmt = c.Statement();
				
		Assert.assertNotNull(stmt);
	}
}
