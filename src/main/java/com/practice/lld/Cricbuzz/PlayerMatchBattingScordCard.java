package com.practice.lld.Cricbuzz;

public class PlayerMatchBattingScordCard {
	
	int mid;
	int pid;
	int totalRuns;
	int totalBalls;
	int ones;
	int twoes;
	int threes;
	int fours;
	int sixes;
	BattingStatus status;
	double strikeRate;
	
	PlayerMatchBattingScordCard(int mid, int pid){
		this.mid = mid;
		this.pid = pid;
		this.status = BattingStatus.YET_TO_PLAY;
	}
	
	public void updateScoreCard(Ball ball) {
		if (BallType.NORMAL == ball.ballType) {
			increaseBalls();
			if (ball.wickedTaken) {
				this.status = BattingStatus.OUT;
			}
			else {
				RunType runType = ball.runType;
				
				if (runType.val>0) {
					updateTotalRun(runType.val);
					if (RunType.ONE == runType) {
						this.ones +=1;
					}
					else if (RunType.TWO == runType) {
						this.twoes +=1;
					}
					else if (RunType.THREE == runType) {
						this.threes+=1;
					}
					else if (RunType.FOUR == runType) {
						this.fours+=1;
					}else if (RunType.SIX == runType) {
						this.sixes+=1;
					}	
				}
			}
			updateStrikeRate();
		}
		
	}
	
	private void updateStrikeRate() {
		this.strikeRate = (this.totalRuns/this.totalBalls)*100;
	}
	
	private void updateTotalRun(int run) {
		this.totalRuns += run;
	}

	private void increaseBalls() {
		this.totalBalls +=1;
	}
	
	public void updateBattingStatus(BattingStatus status) {
		this.status = status;
	}
}
