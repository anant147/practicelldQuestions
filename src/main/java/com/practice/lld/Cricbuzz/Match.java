package com.practice.lld.Cricbuzz;

public class Match {
	
	int mid;
	Team teamA;
	Team teamB;
	String date;
	String venue;
	Inning inningA;
	Inning inningB;
	int totalOver;
	int maxOverByBowler;
	
	public Match(int mid, Team teamA, Team teamB, String date, String venue, int totalOver, int maxOverByBowler) {
		this.mid = mid;
		this.teamA = teamA;
		this.teamB = teamB;
		this.date = date;
		this.venue = venue;
		this.totalOver = totalOver;
		this.maxOverByBowler = maxOverByBowler;
	}
	
	public void playGame() {
		
		this.inningA = new Inning(1, this.mid, this.teamA, this.teamB);
		this.inningA.startInning(false, 0);
		
		this.inningB = new Inning(2, this.mid, this.teamB, this.teamA);
		this.inningB.startInning(true, this.inningA.battingTeamScoreCard.totalRuns+1);
		
		this.inningA.printStatsOfInning();
		this.inningB.printStatsOfInning();
		
	}
}
