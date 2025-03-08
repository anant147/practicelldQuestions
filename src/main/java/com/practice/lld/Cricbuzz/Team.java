package com.practice.lld.Cricbuzz;

import java.util.List;

public class Team {
	
	int tid;
	String tname;
	List<MatchPlayer> playingElevens;
	PlayerBattingController battingController;
	PlayerBowlingController bowlingController;
	
	public Team(int tid, String tname, List<MatchPlayer> playingElevens, int maxOver, int totalOver) {
		this.tid = tid;
		this.tname = tname;
		this.playingElevens = playingElevens;
		this.battingController = new PlayerBattingController(playingElevens);
		this.bowlingController = new PlayerBowlingController(playingElevens, maxOver, totalOver);
	}
	
	// batting
	/*
	 * setNextBattingPlayer
	isTeamAllOut
	outMatchPlayer
	startBattingInnings
	getStriker
	 */
	
	public void setNextBattingPlayer() {
		this.battingController.setNextBattingPlayer();
	}
	
	public boolean isTeamAllOut() {
		return this.battingController.isTeamAllOut();
	}
	
	public void outMatchPlayerAndSetNextPlayer(MatchPlayer player) {
		this.battingController.outMatchPlayerAndSetNextPlayer(player);
	}
	
	public void startBattingInnings() {
		this.battingController.startBattingInnings();
	}
	
	public MatchPlayer getStriker() {
		return this.battingController.getStriker();
	}
	
	public void changeStrike() {
		 this.battingController.changeStrike();
	}
	
	
	// bowling
		/*
		isInningsInProgress
		getCurrentBowler
		 */
	
	public boolean isInningsInProgress() {
		return this.bowlingController.isInningsInProgress();
	}
	
	public MatchPlayer getCurrentBowler() {
		return this.bowlingController.getCurrentBowler();
	}
	
	public Over addOver(MatchPlayer matchPlayer, int mid, int igid, int overNo) {
		Over over = matchPlayer.addOver( mid,  igid,  overNo);
		return over;
	}
	
	public void endOver(MatchPlayer mp, Over over) {
		
	}
}
