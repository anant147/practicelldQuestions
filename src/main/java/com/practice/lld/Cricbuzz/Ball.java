package com.practice.lld.Cricbuzz;

public class Ball {
	
	int bid;
	int overNo;
	MatchPlayer bowledBy;
	MatchPlayer playedby;
	BallType ballType;
	RunType runType;
	boolean wickedTaken;
	
	public Ball(int bid, int overNo, MatchPlayer bowledBy, MatchPlayer playedBy) {
		this.bid = bid;
		this.overNo = overNo;
		this.bowledBy = bowledBy;
		this.playedby = playedBy;
		configureBallDetails();
	}

	private void configureBallDetails() {
		double val = Math.random();
		if (val>=0.0 && val<0.05) {
			this.ballType = BallType.NORMAL;
			this.wickedTaken = true;
		}
		else if (val>=0.05 && val < 0.12) {
			this.ballType = BallType.NOBALL;
		}
		else if (val>=0.12 && val < 0.20) {
			this.ballType = BallType.WIDE;
		}
		else if (val>=0.20 && val<0.30) {
			this.ballType = BallType.NORMAL;
			this.runType = RunType.ZERO;
		}
		else if (val>=0.30 && val<0.60) {
			this.ballType = BallType.NORMAL;
			this.runType = RunType.ONE;
		}
		else if (val>=0.60 && val<0.80) {
			this.ballType = BallType.NORMAL;
			this.runType = RunType.TWO;
		}
		else if (val>=0.80 && val<0.84) {
			this.ballType = BallType.NORMAL;
			this.runType = RunType.THREE;
		}
		else if (val>0.84 && val<0.95) {
			this.ballType = BallType.NORMAL;
			this.runType = RunType.FOUR;
		}
		else {
			this.ballType = BallType.NORMAL;
			this.runType = RunType.SIX;
		}
	}
	
}
