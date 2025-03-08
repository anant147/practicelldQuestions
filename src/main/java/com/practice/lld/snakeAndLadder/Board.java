package com.practice.lld.snakeAndLadder;

import java.util.HashSet;
import java.util.Set;

public class Board {

	int n ;
	Cell[][] cells;
	
	public Board(int n, int snakeCnt, int ladderCnt) {
		this.n = n;
		this.cells = new Cell[n][n];
		setSnakeLadder(n, snakeCnt, ladderCnt);
	}

	private void setSnakeLadder(int n, int snakeCnt, int ladderCnt) {
		
		int s = 0;
		Set<Integer> set = new HashSet<Integer>();
		int sq = (n*n);
		
		while (s<snakeCnt) {
			int x = (int) (Math.random() * sq);
			int y = (int) (Math.random() * sq);
			
			if (!set.contains(x) && !set.contains(y) && x!=y && x<sq && y<sq) {
				s++;
				int a = x<y ? x : y;
				int b = x>y ? x : y;
				set.add(x); set.add(y);
				int x1 = b/n;
				int y1 = b%n;
				this.cells[x1][y1] = new Cell(new Jump(b, a));
			}
		}
		
		int l=0;
		while (l<ladderCnt) {
			int x = (int) (Math.random() * sq);
			int y = (int) (Math.random() * sq);
			
			if (!set.contains(x) && !set.contains(y) && x!=y && x<sq && y<sq) {
				l++;
				int a = x<y ? x : y;
				int b = x>y ? x : y;
				set.add(x); set.add(y);
				int x1 = a/n;
				int y1 = a%n;
				this.cells[x1][y1] = new Cell(new Jump( a,b));
			}
		}
		
	}
}
