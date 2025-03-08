package com.practice.lld.SnakeAndLadderInterview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
	
	Board board;
	Deque<Player> players;
	List<Dice> dices;
	Player winner;
	boolean gameEnded;
	
	public Game(int n, int p, int m) {
		this.board = new Board(n);
		createPlayers(p);
		createDices(m);
	}

	private void createDices(int m) {
		this.dices = new ArrayList<>();
		for (int i=1;i<=m;i++) {
			this.dices.add(new Dice(i));
		}
	}

	private void createPlayers(int p) {
		
		this.players = new LinkedList<>();
		for (int i=1;i<=p;i++) {
			this.players.add( new Player(i, "name"+i));
		}
	}
	
	public void startGame() {
		
	}
}
