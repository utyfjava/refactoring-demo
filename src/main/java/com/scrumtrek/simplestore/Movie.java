package com.scrumtrek.simplestore;

/**
 * 
 * @author pkulimov
 * rerewrewrew
 */
public class Movie {
	private String m_Title;
	private PriceCodes m_PriceCode;

	/**
	 * 
	 * @param title
	 * @param priceCode
	 */
	public Movie(String title, PriceCodes priceCode) {
		m_Title = title;
		m_PriceCode = priceCode;
	}
	/**
	 * 
	 * @return PriceCodes
	 */
	public PriceCodes getPriceCode()	{
		return m_PriceCode;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setPriceCode(PriceCodes value) {
		m_PriceCode = value;
	}

	/**
	 * 
	 * @return String
	 */
	public String getTitle() {
		return m_Title;
	}
}

