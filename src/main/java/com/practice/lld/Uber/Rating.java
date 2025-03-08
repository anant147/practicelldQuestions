package com.practice.lld.Uber;

public enum Rating {
	UNASSIGNED,
	ONE_STAR,
	TWO_STARS,
	THREE_STARS,
	FOUR_STARS,
	FIVE_STARS;
	
	public static String ratingToString(Rating rtg) {
		if (rtg == Rating.ONE_STAR) {
			return "one star";
		}
		else if (rtg == Rating.TWO_STARS ) {
			return "two stars";
		}
		else if (rtg == Rating.THREE_STARS) {
			return "three stars";
		}
		else if (rtg == Rating.FOUR_STARS) {
			return "four stars";
		}
		else if (rtg == Rating.FIVE_STARS) {
			return "five stars";
		}
		return "invalid rating";
	}
	
	public static boolean isHighRating(Rating rtg) {
		return Rating.FOUR_STARS == rtg || Rating.FIVE_STARS == rtg;
	}
	
	
}
