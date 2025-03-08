package com.practice.lld.Cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Inning {
	
	int igid;
	int mid;
	Team battingTeam;
	Team bowlingTeam;
	List<Over> overs;
	BattingTeamScoreCard battingTeamScoreCard;
	BowlingTeamScoreCard bowlingTeamScoreCard;
	
	public Inning(int igid, int mid, Team battingTeam, Team bowlingTeam ) {
		this.igid = igid;
		this.mid = mid;
		this.battingTeam = battingTeam;
		this.bowlingTeam = bowlingTeam;
		this.overs = new ArrayList<>();
		this.battingTeamScoreCard = new BattingTeamScoreCard(igid, mid, battingTeam.tid);
		this.bowlingTeamScoreCard = new BowlingTeamScoreCard(igid, mid, bowlingTeam.tid);
	}
	
	public void updateStats(Ball ball, MatchPlayer currentBowler, MatchPlayer striker) {
		this.battingTeamScoreCard.updateBattingTeamScoreCard(ball);
		this.bowlingTeamScoreCard.updateBowlingTeamScoreCard(ball);
		currentBowler.updateBowlingScoreCard(ball.overNo, ball);
		striker.updateBattingScoreCard(ball);
	}
	
	public void printStatsOfInning() {
		this.battingTeamScoreCard.printStats();
		this.bowlingTeamScoreCard.printStats();
	}
	
	
	public void startInning(boolean secondInning, int scoreToChase) {
		
		System.out.println(" \n\n innings : " + this.igid + " started. team : " + battingTeam.tid + " is batting");
		
		this.battingTeam.startBattingInnings();
		
		int overNo = 0;
		while(isInningInProgress()) {
			MatchPlayer currentBowler = this.bowlingTeam.getCurrentBowler();
			System.out.println(" mp : " + currentBowler.player.pid);;
			Over over = this.bowlingTeam.addOver(currentBowler, this.mid, this.igid, overNo);
			
			addOver(over);
			
			int bid = 0;
			while(over.validBalls<6) {
				Ball ball = new Ball( bid,  overNo, currentBowler, battingTeam.getStriker());
				updateStats(ball, ball.bowledBy, ball.playedby);
				
				if (secondInning && scoreToChase<= battingTeamScoreCard.totalRuns) {
					int wick = 10 - battingTeamScoreCard.wickets;
					System.out.println(" team : " + battingTeam.tid + " won the match by " + wick + " wickets");
					return;
				}
				
				if (ball.wickedTaken) {
					battingTeam.outMatchPlayerAndSetNextPlayer(battingTeam.getStriker());
				}
				else if (RunType.ONE == ball.runType || RunType.THREE == ball.runType) {
					battingTeam.changeStrike();
				}
			}			
			currentBowler.endOver(overNo++);
			battingTeam.changeStrike();
			System.out.println();
		}
		
		System.out.println(" innings : " + this.igid + " end. team : " + battingTeam.tid + " has finished batting");

		System.out.println("\n");
		if (secondInning && scoreToChase-1> battingTeamScoreCard.totalRuns) {
			int diff = scoreToChase - battingTeamScoreCard.totalRuns-1;
			System.out.println(" team : " + bowlingTeam.tid + " won the match by " + diff + " runs");
			return;
		}
		else if (!secondInning) {
			System.out.println(" team : " + battingTeam.tid + " give target of "  + (battingTeamScoreCard.totalRuns+1) + " to team : " + bowlingTeam.tid);
		}
		else if (secondInning && battingTeamScoreCard.totalRuns == scoreToChase-1) {
			System.out.println(" match tied b.w team : " + battingTeam.tid + " and team : " + bowlingTeam.tid);
		}
	}

	private boolean isInningInProgress() {
		return this.bowlingTeam.isInningsInProgress() && !this.battingTeam.isTeamAllOut();
	}
	
	public void addOver(Over over) {
		this.overs.add(over);
		this.bowlingTeamScoreCard.addOver(over);
	}
	
	
}
