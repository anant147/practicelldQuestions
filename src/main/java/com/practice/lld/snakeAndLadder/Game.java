package com.practice.lld.snakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
	
	Board board;
	Dice dice;
	Deque<Player> players;
	
	public Game(int n, int snakeCnt, int ladderCnt) {
	   this.board = new Board(n, snakeCnt, ladderCnt);
	   this.dice = new Dice(1, 6);
	   addPlayers();
	}

	private void addPlayers() {
		this.players = new LinkedList<>();
		this.players.add(new Player("p1"));
		this.players.add(new Player("p2"));
	}
	
	public void startGame() {
		System.out.println(" starting the game");
		System.out.println(" size of players : " + this.players.size());
		
		int n = this.board.n;
		int target = n*n-1;
		
		while (true) {
			Player p1 = this.players.pollFirst();
			System.out.println("  player : " + p1.name + " , cur pos : " + p1.currentPos );
			int diceVal = this.dice.rollDice();
			System.out.println(" dice val : " + diceVal);
			int newpos = p1.currentPos + diceVal;
			int newVal = checkPosWithCells(newpos,n);
			p1.currentPos = newVal;
			System.out.println(" player : " + p1.name + " , new pos : " + p1.currentPos);
			
			if (newVal>=target) {
				System.out.println("player " + p1.name + " win the game");
				break;
			}
			this.players.addLast(p1);
		}
		
		System.out.println(" ending the game");
	}

	private int checkPosWithCells(int newpos, int n) {
		int x = newpos/n;
		int y = newpos%n;
		
		if (this.board.cells[x][y] != null) {
			int v1 = this.board.cells[x][y].jump.start;
			int v2 = this.board.cells[x][y].jump.end;
			if (v1<v2) {
				System.out.println("there is ladder");
			}
			else {
				System.out.println("there is snake");
			}
			System.out.println("so, move from " + newpos + " to " + v2);
			return v2;
		}
		return newpos;
	}
	
}
