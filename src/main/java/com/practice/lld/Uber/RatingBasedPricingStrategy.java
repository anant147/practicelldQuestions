package com.practice.lld.Uber;

public class RatingBasedPricingStrategy implements PricingStrategy {

	@Override
	public double calculatePrice(TripMetadata tripMetaData) {
		double price = Rating.isHighRating(tripMetaData.getRiderRating()) ? 55 : 65;
		System.out.println(" based on " + Rating.ratingToString(tripMetaData.getRiderRating()) + " rider rating, price of trip is : " + price);
		return price;
	}

}