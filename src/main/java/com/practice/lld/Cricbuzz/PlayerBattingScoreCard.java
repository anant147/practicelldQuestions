package com.practice.lld.Cricbuzz;

import java.util.HashMap;
import java.util.Map;

public class PlayerBattingScoreCard {
	
	int pid;
	Map<Integer, PlayerMatchBattingScordCard> matchMap;
	int totalRuns;
	int totalBalls;
	int ones;
	int twoes;
	int threes;
	int fours;
	int sixes;
	int totalInnings;
	double strikeRate;
	int fifties;
	int hundreds;
	
	public PlayerBattingScoreCard(int pid){
		this.pid = pid;
		this.matchMap = new HashMap<>();
	}
	
	public void updateStats(PlayerMatchBattingScordCard scorecard) {
		this.totalInnings +=1;
		this.totalRuns += scorecard.totalRuns;
		this.totalBalls += scorecard.totalBalls;
		this.ones += scorecard.ones;
		this.twoes += scorecard.twoes;
		this.threes += scorecard.threes;
		this.fours += scorecard.fours;
		this.sixes += scorecard.sixes;
		updateStrikeRate(scorecard.strikeRate);
		updateMileStones(scorecard.totalRuns);
		this.matchMap.put(scorecard.mid, scorecard);
	}

	private void updateMileStones(int runs) {
		if (runs>=50) {
			this.fifties+=1;
		}
		else if (runs>=100) {
			this.hundreds+=1;
		}
	}

	private void updateStrikeRate(double strikeRate) {
		int ing = this.totalInnings;
		this.strikeRate = ((this.strikeRate * (ing-1)) + strikeRate)/ing;
	}
}
