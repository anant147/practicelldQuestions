package com.practice.lld.Cricbuzz;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlayerBowlingController {
	
	Deque<MatchPlayer> bowlingLineUp;
	Map<MatchPlayer, Integer> overCount;
	MatchPlayer currentBowler;
	int maxOverByPlayer;
	int totalOver;
	int currentOverCount;
	
	public PlayerBowlingController(List<MatchPlayer> mps, int maxOver, int totalOver) {
		this.maxOverByPlayer = maxOver;
		this.totalOver = totalOver;
		bowlingLineUp = new LinkedList<>();
		overCount = new HashMap<>();
		setBowlingLineUp(mps);
	}

	private void setBowlingLineUp(List<MatchPlayer> mps) {
		
		Set<MatchPlayer> mpset = new HashSet<>();
		for (MatchPlayer mp : mps) {
			if (mp.player.playerType.contains(PlayerType.BOWLER)) {
				mpset.add(mp);
			}
		}
		
		for (MatchPlayer mp : mps) {
			if (mp.player.playerType.contains(PlayerType.ALL_ROUNDER)) {
				mpset.add(mp);
			}
		}
		
		for (MatchPlayer mp : mpset) {
			this.bowlingLineUp.add(mp);
		}
		
		System.out.println(" no. of bowlers : " + this.bowlingLineUp.size());
	}
	
	public boolean isInningsInProgress() {
		return currentOverCount < totalOver;
	}
	
	public MatchPlayer getCurrentBowler() {
		
		if (isBowlerValid(this.currentBowler)) {
			this.bowlingLineUp.addLast(this.currentBowler);
		}
		
		this.currentOverCount++;

		
		while (!this.bowlingLineUp.isEmpty()) {
			
			MatchPlayer mp = this.bowlingLineUp.pollFirst();
			if (isBowlerValid(mp)) {
				this.currentBowler = mp;
				this.overCount.put(mp,  this.overCount.getOrDefault(mp, 0) + 1);
				return mp;
			}
		}
		
		return this.currentBowler;
	}

	private boolean isBowlerValid(MatchPlayer mp) {
		return mp != null && ( this.overCount.get(mp) == null || this.overCount.get(mp)<this.totalOver);
	}
}
