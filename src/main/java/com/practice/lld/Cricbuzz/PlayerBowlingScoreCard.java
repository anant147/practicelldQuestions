package com.practice.lld.Cricbuzz;

import java.util.HashMap;
import java.util.Map;

public class PlayerBowlingScoreCard {
	
	int pid;
	Map<Integer, PlayerMatchBowlingScoreCard> matchMap; 
	int wickets;
	int noBalls;
	int wides;
	int totalMatches;
	int runsConceeded;
	int threeWickets;
	int fiveWickets;
	double economy;
	
	
	public PlayerBowlingScoreCard(int pid) {
		this.pid = pid;
		this.matchMap = new HashMap<>();
	}
	
	public void updateStats(PlayerMatchBowlingScoreCard scorecard) {
		this.totalMatches +=1;
		this.matchMap.put(scorecard.mid, scorecard);
		this.wickets += scorecard.wickets;
		this.noBalls += scorecard.noBalls;
		this.wides += scorecard.wides;
		this.runsConceeded += scorecard.runsConceeded;
		updateMileStone(scorecard.wickets);
		updateEconomy(scorecard.economy);
	}

	private void updateEconomy(double economy) {
		int ing = this.totalMatches;
		this.economy = ((ing-1)* this.economy + economy)/ing;
	}

	private void updateMileStone(int wickets) {
		if (wickets>=5) {
			this.fiveWickets += 1;
		}
		else if (wickets>=3) {
			this.threeWickets +=1;
		}
	}
	
	
}
