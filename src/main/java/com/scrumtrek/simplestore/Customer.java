package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * 
 * @author pkulimov
 *  qweqweqwe
 *  
 */
public class Customer {
	private String m_Name;
	private List<Rental> m_Rentals = new ArrayList<Rental>();

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
					
				case XXXPriceCode:
					thisAmount += 4;
					if (each.getDaysRented() > 4)
					{
						thisAmount += (each.getDaysRented() - 4) * 1.5;
					}
					break;
			}
			
			l.add(new StatementRental(each.getMovie(), thisAmount));
		}
		
		return l;
	}

	/**
	 * 
	 * @return String
	 */
	public String StatementString () {
		double totalAmount = 0;
		String result = "Rental record for " + m_Name + "\n";
		for(StatementRental sr: this.Statement()) {
			result += "\t" + sr.getMovie().getTitle() + "\t" + sr.getAmount() + "\n";
			totalAmount += sr.getAmount();
		}
		result += "Amount owed is " + totalAmount;
		
		return result;
	}
	
	/**
	 * 
	 * @return String
	 */
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

		return j.toString();
	}
}

