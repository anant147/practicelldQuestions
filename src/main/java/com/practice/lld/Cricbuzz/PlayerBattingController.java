package com.practice.lld.Cricbuzz;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayerBattingController {

	Queue<MatchPlayer>  yetToPlay;
	MatchPlayer striker;
	MatchPlayer nonStriker;
	
	public PlayerBattingController(List<MatchPlayer> matchPlayers) {
		this.yetToPlay = new LinkedList<>();
		
		for (MatchPlayer mp : matchPlayers) {
			this.yetToPlay.add(mp);
		}
	}
	
	
	public void setNextBattingPlayer() {
		MatchPlayer mp = yetToPlay.poll();
		mp.updateBattingStatus(BattingStatus.NOT_OUT);
		if (striker == null) {
			striker = mp;
		}
		else if (nonStriker == null) {
			nonStriker = mp;
		}
	}
	
	public boolean isTeamAllOut() {
		return (yetToPlay.isEmpty() && ( striker == null || nonStriker == null) );
	}
	
	public void outMatchPlayerAndSetNextPlayer(MatchPlayer mp) {
		mp.updateBattingStatus(BattingStatus.OUT);
		if (mp.equals(striker)) {
			striker = null;
		}
		else {
			nonStriker = null;
		}
		setNextBattingPlayer();
	}
	
	public void startBattingInnings() {
		MatchPlayer mp1 = yetToPlay.poll();
		MatchPlayer mp2 = yetToPlay.poll();
		this.striker = mp1;
		this.nonStriker = mp2;
	}
	
	public MatchPlayer getStriker() {
		return this.striker;
	}
	
	public void changeStrike() {
		MatchPlayer mp = this.striker;
		this.striker = this.nonStriker;
		this.nonStriker = mp;
	}
}

