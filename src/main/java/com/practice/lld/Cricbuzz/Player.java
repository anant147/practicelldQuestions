package com.practice.lld.Cricbuzz;

import java.util.List;

public class Player {
	
	int pid;
	String name;
	List<PlayerType> playerType;
	PlayerBattingScoreCard playerBattingScoreCard;
	PlayerBowlingScoreCard playerBowlingScoreCard;
	
	public Player(int pid, String name, List<PlayerType> pt) {
		
		this.pid = pid;
		this.name = name;
		this.playerType = pt;
		this.playerBattingScoreCard = new PlayerBattingScoreCard(this.pid);
		this.playerBowlingScoreCard = new PlayerBowlingScoreCard(this.pid);
	}
	
	public void updateBattingStats(PlayerMatchBattingScordCard matchScoreCard) {
		this.playerBattingScoreCard.updateStats(matchScoreCard);
	}
	
	public void updateBowlingStats(PlayerMatchBowlingScoreCard matchScoreCard) {
		this.playerBowlingScoreCard.updateStats(matchScoreCard);
	}
}
