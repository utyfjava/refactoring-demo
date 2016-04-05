package com.scrumtrek.simplestore;

/**
 * 
 * @author pkulimov
 * hgfhg
 */
public class StatementRental {
	private Movie m_Movie;
	private double m_Amount;

	/**
	 * 
	 * @param movie
	 * @param Amount
	 */
	public StatementRental(Movie movie, double Amount) {
		m_Movie = movie;
		m_Amount = Amount;
	}

	/**
	 * 
	 * @return double
	 */
	public double getAmount() {
		return m_Amount;
	}

	/**
	 * 
	 * @return Movie
	 */
	public Movie getMovie() {
		return m_Movie;
	}
}
