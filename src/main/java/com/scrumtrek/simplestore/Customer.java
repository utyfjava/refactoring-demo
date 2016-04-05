package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONStringer;

public class Customer {
	private String m_Name;
	private List<Rental> m_Rentals = new ArrayList<Rental>();
	int frequentRenterPoints = 0;

	public Customer(String name) {
		m_Name = name;
	}

	public String getName() {
		return m_Name;
	}


	public void addRental(Rental arg){
		m_Rentals.add(arg);
	}

	/**
	 * 
	 * @return List StatementRental
	 */
	public List<StatementRental> Statement()
	{
		double totalAmount = 0;
		List<StatementRental> l = new ArrayList<StatementRental>();
		
		for(Rental each: m_Rentals) {
			double thisAmount = 0;
			
			// Determine amounts for each line
			switch(each.getMovie().getPriceCode()) {
				case Regular:
					thisAmount += 2;
					if (each.getDaysRented() > 2)
					{
						thisAmount += (each.getDaysRented() - 2) * 1.5;
					}
					break;
	
				case NewRelease:
					thisAmount += each.getDaysRented() * 3;
					break;
	
				case Childrens:
					thisAmount += 1.5;
					if (each.getDaysRented() > 3)
					{
						thisAmount = (each.getDaysRented() - 3) * 1.5;
					}
					break;
			}
			
			l.add(new StatementRental(each.getMovie(), thisAmount));
			// Add frequent renter points
			frequentRenterPoints++;

			// Add bonus for a two-day new-release rental
			if ((each.getMovie().getPriceCode() == PriceCodes.NewRelease) && (each.getDaysRented() > 1))
			{
				frequentRenterPoints ++;
			}
		}
		
		return l;
	}
	
	public String StatementString () {
		double totalAmount = 0;
		String result = "Rental record for " + m_Name + "\n";
		for(StatementRental sr: this.Statement()) {
			result += "\t" + sr.getMovie().getTitle() + "\t" + sr.getAmount() + "\n";
			totalAmount += sr.getAmount();
		}
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points.";
		
		return result;
	}
	
	public String StatementJson () {
		double totalAmount = 0;
		JSONObject j = new JSONObject();
		JSONObject jm = new  JSONObject();
		for(StatementRental sr: this.Statement()) {
			jm.put(sr.getMovie().getTitle(), sr.getAmount());
			totalAmount += sr.getAmount();
		}
		
		j.put("customer", m_Name);
		j.append("rental", jm);
		j.put("totalAmount", totalAmount);
		j.put("frequentRenterPoints", frequentRenterPoints);

		return j.toString();
	}
}

