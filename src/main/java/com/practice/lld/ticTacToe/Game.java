package com.practice.lld.ticTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
	
	Deque<Player> players;
	Board board;
	
	public Game() {
		initialize();
	}

	private void initialize() {
		this.board = new Board(3);
		
		this.players = new LinkedList<>();
		
		players.add(new Player("Player1", new PlayingPieceX(PieceType.X)));
		players.add(new Player("Player2", new PlayingPieceO(PieceType.O)));

	}
	
	public void startGame() {
		System.out.println("starting the game");
		PlayingPiece[][] bd = board.getPieces();
		int size = board.getSize();
		
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		 
		
		while(true) {
			
			Player player = players.pollFirst();
			
			int x = -1;
			int y = -1;
			
			while (true) {
				System.out.println("Player : " + player.name +", enter the values of x and y : ");
				System.out.println(" enter x : ");
				x = sc.nextInt();
				System.out.println(" enter y : ");
				y = sc.nextInt();
				
				boolean valid = isValidValue(x, y, size, bd);
				if (valid) {
					break;
				}
			}
			
			bd[x][y] = player.getPiece();
			
			printtheBoard(size, bd);
			
			int val = gameFinished(bd, size);
			
			if (val == 0) {
				players.addLast(player);
			}
			else if (val == 1) {
				System.out.println(" game won by " + player.name);
				break;
			}
			else {
				System.out.println(" game tied");
				break;
			}
		}
		
		System.out.println("ending the game");
	}

	private int gameFinished(PlayingPiece[][] bd, int n) {
		
		for (int i=0;i<n;i++) {
			PlayingPiece x = bd[i][0];
			int cond = 0;
			
			for (int j=0;j<n;j++) {
				if (bd[i][j] == null || !x.equals(bd[i][j]))
				{
					cond = 1;
					break;
				}
			}
			
			if (cond == 0) {
				return 1;
			}
			
		}
		
		for (int i=0;i<n;i++) {
			PlayingPiece x = bd[0][i];
			int cond = 0;
			
			for (int j=0;j<n;j++) {
				if (bd[j][i] == null || !x.equals(bd[j][i]))
				{
					cond = 1;
					break;
				}
			}
			
			if (cond == 0) {
				return 1;
			}
		}
		
		int cond = 0;
		PlayingPiece x = bd[0][0];
		
		for (int i=0;i<n;i++) {
			if (bd[i][i] == null || !x.equals(bd[i][i])) {
				cond = 1;
				break;
			}
		}
		
		if (cond == 0) {
			return 1;
		}
		
		cond = 0;
		x = bd[0][n-1];

		for (int i=0;i<n;i++) {
			if (bd[i][n-1-i] == null || !x.equals(bd[i][n-1-i])) {
				cond = 1;
				break;
			}
		}
		
		if (cond == 0) {
			return 1;
		}
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if (bd[i][j] == null) {
					return 0;
				}
			}
		}
		
		return 2;
	}

	private void printtheBoard(int n, PlayingPiece[][] bd) {
		System.out.println("\n printing the board");
		
		for (int i=0;i<n;i++) {
			System.out.print(" | ");
			for (int j=0;j<n;j++) {
				if (bd[i][j] != null)
					System.out.print(" " + bd[i][j].pieceType + " | ");
				else
					System.out.print("   | ");

			}
			System.out.println();
		}
	}

	private boolean isValidValue(int x, int y, int size, PlayingPiece[][] bd) {
		if (x>=0 && x<size && y>=0 && y<size && bd[x][y] == null)
			return true;
		return false;
	}
}
