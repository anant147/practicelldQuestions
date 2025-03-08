package com.practice.lld.Cricbuzz;

public class BattingTeamScoreCard {
	
	int igid;
	int mid;
	int tid;
	int totalRuns;
	int totalBalls;
	int ones;
	int twoes;
	int threes;
	int fours;
	int sixes;
	int wickets;
	int wide;
	int noBall;
	
	public BattingTeamScoreCard(int igid, int mid, int tid) {
		this.igid = igid;
		this.mid = mid;
		this.tid = tid;
	}
	
	public void updateBattingTeamScoreCard(Ball ball) {
		if (ball.ballType == BallType.WIDE) {
			this.wide +=1;
			updateRun(1);
		}
		else if (ball.ballType == BallType.NOBALL) {
			this.noBall +=1;
			updateRun(1);
		}
		else {
			this.totalBalls +=1;
			
			if (ball.wickedTaken) {
				this.wickets +=1;
			}
			else {
				int val = ball.runType.val;
				updateRun(val);
				
				RunType rt = ball.runType;
				
				if (RunType.ONE == rt) {
					this.ones +=1;
				}
				else if (RunType.TWO == rt) {
					this.twoes +=1;
				}
				else if (RunType.THREE == rt) {
					this.threes +=1;
				}
				else if (RunType.FOUR == rt) {
					this.fours +=1;
				}
				else if (RunType.SIX == rt) {
					this.sixes +=1;
				}
			}
		}
	}
	
	public void updateRun(int run) {
		this.totalRuns += run;
	}
	
	public void printStats() {
		System.out.println(" \n Stats of Batting team : " + tid + " for ing : " + igid + " in match : " + mid);
		System.out.println(" totalRun : " + this.totalRuns);
		System.out.println(" totalballs : " + this.totalBalls);
		System.out.println(" wickets fallen : " + this.wickets);
		System.out.println(" total ones : " + this.ones);
		System.out.println(" total two : " + this.twoes);
		System.out.println(" total 3s : " + this.threes);
		System.out.println(" total 4s : " + this.fours);
		System.out.println(" total 6s : " + this.sixes);
		System.out.println(" total wides : " + this.wide);
		System.out.println(" total noballs : " + this.noBall);
	}
}
