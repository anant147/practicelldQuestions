package com.practice.lld.Cricbuzz;

public class MatchPlayer {
	
	int mpid;
	int mid;
	Player player;
	PlayerMatchBattingScordCard playerMatchBattingScordCard;
	PlayerMatchBowlingScoreCard playerMatchBowlingScoreCard;
	
	public MatchPlayer(int mpid, int mid, Player player) {
		this.mpid = mpid;
		this.mid = mid;
		this.player = player;
		this.playerMatchBattingScordCard = new PlayerMatchBattingScordCard(player.pid, mid);
		this.playerMatchBowlingScoreCard = new PlayerMatchBowlingScoreCard( player.pid, mid);
	}
	
	public void updateBattingStatus(BattingStatus status) {
		playerMatchBattingScordCard.updateBattingStatus(status);
	}
	
	public void updateBattingScoreCard(Ball ball) {
		this.playerMatchBattingScordCard.updateScoreCard(ball);
	}
	
	public void updateBowlingScoreCard(int overNo, Ball ball) {
		this.playerMatchBowlingScoreCard.updateScoreCard(overNo, ball);
	}
	
	public Over addOver(int mid, int ingind, int overNo) {
		return this.playerMatchBowlingScoreCard.addOver(mid, ingind, overNo);
	}
	
	public void addBall(int overNo, Ball ball) {
		this.playerMatchBowlingScoreCard.updateScoreCard(overNo, ball);
	}
	
	public void endOver(int overNo) {
		this.playerMatchBowlingScoreCard.endOver(overNo);
	}
}
