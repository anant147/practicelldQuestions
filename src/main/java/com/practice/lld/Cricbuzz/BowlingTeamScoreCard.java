package com.practice.lld.Cricbuzz;

import java.util.HashMap;
import java.util.Map;

public class BowlingTeamScoreCard {
	
	int igid;
	int mid;
	int tid;
	Map<Integer, Over> overMap;
	int wickets;
	int noBalls;
	int wides;
	int runsConceeded;
	double economy;
	
	public BowlingTeamScoreCard(int igid, int mid, int tid) {
		this.igid = igid;
		this.mid = mid;
		this.tid = tid;
		this.overMap = new HashMap<>();
	}
	
	public void updateBowlingTeamScoreCard(Ball ball) {
		addBall(ball.overNo, ball);
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
		int b = ((overCnt-1)*6 + validBalls);
		b = b!=0 ? b : 1;
		
		this.economy = (this.runsConceeded / b) * 6;
	}
	
	public Over addOver(Over over) {
		this.overMap.put(over.overNo, over);
		return over;
	}
	
	public void addBall(int overNo, Ball ball) {
		this.overMap.get(overNo).addBall(ball);
	}
	
	public void endOver(int overNo) {
		this.overMap.get(overNo).endOver();
	}

	private void updateRunConceeded(int run) {
		this.runsConceeded += run;
	}
	
	
	public void printStats() {
		System.out.println(" \n Stats of bowling team : " + tid + " for ing : " + igid + " in match : " + mid);
		System.out.println("total runs conceeded : " + this.runsConceeded);
		System.out.println("total wickets : " + this.wickets);
		System.out.println("total overs : " + this.overMap.size());
		System.out.println("total wides : " + this.wides);
		System.out.println("total no balls : " + this.noBalls);
		System.out.println("total economy : " + this.economy);
	}
}
