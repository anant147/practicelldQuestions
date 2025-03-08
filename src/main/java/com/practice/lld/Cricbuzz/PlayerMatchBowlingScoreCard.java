package com.practice.lld.Cricbuzz;

import java.util.HashMap;
import java.util.Map;

public class PlayerMatchBowlingScoreCard {
	
	int pid;
	int mid;
	Map<Integer, Over> overMap;
	int wickets;
	int noBalls;
	int wides;
	int runsConceeded;
	double economy;
	
	public PlayerMatchBowlingScoreCard(int pid, int mid) {
		this.pid = pid;
		this.mid = mid;
		this.overMap = new HashMap<>();
	}
	
	public void updateScoreCard(int overNo, Ball ball) {
		if (ball.wickedTaken) {
			this.wickets+=1;
		}
		else if (ball.ballType == BallType.NOBALL) {
			updateRunConceeded(1);
			this.noBalls +=1;
		}
		else if (ball.ballType == BallType.WIDE) {
			updateRunConceeded(1);
			this.wides +=1;
		}
		else {
			updateRunConceeded(ball.runType.val);
		}
		updateEconomy(ball.overNo);
	}
	
	private void updateEconomy(int overNo) {
		int overCnt = this.overMap.size();
		int validBalls = this.overMap.get(overNo).validBalls;
		System.out.println("overNo : - " + overNo + " , bowler : " + this.pid + ", over cnt : " + overCnt + " , valid ball : " + validBalls);
		int b = ((overCnt-1)*6 + validBalls);
		b = b!=0 ? b : 1;
		this.economy = (this.runsConceeded / b) * 6;
	}
	
	public Over addOver(int mid, int ingid, int overNo) {
		Over over = new Over(mid, ingid, overNo);
		this.overMap.put(overNo, over);
		return over;
	}
	
	public void endOver(int overNo) {
		this.overMap.get(overNo).endOver();
	}

	private void updateRunConceeded(int run) {
		this.runsConceeded += run;
	}
	
	
}
