package com.practice.lld.Cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Over {
	
	int mid;
	int ingid;
	int overNo;
	List<Ball> balls;
	OverStatus ovStatus;
	int validBalls;
	
	public Over(int mid, int ingid, int overNo) {
		this.mid = mid;
		this.ingid = ingid;
		this.overNo = overNo;
		this.balls = new ArrayList<>();
		this.ovStatus = OverStatus.STARTED;
	}
	
	public void addBall(Ball ball) {
		System.out.println("ball type : " + ball.ballType);
		this.balls.add(ball);
		if (BallType.NORMAL == ball.ballType) {
			this.validBalls +=1;
		}
	}
	
	public void endOver() {
		this.ovStatus = OverStatus.FINISHED;
	}
}
