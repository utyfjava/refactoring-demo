package com.scrumtrek.simplestore;

public class StatementRental {
	private Movie m_Movie;
	private double m_Amount;

	public StatementRental(Movie movie, double Amount) {
		m_Movie = movie;
		m_Amount = Amount;
	}

	public double getAmount() {
		return m_Amount;
	}

	public Movie getMovie() {
		return m_Movie;
	}
}
