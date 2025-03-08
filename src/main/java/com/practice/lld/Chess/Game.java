package com.practice.lld.Chess;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	Board board;
	Deque<Player> players;
	List<Move> moves;
	List<Kill> kills;
	boolean winner;
	
	public Game() {
		this.board = new Board();
		this.players = new LinkedList<>();
		this.moves = new ArrayList<>();
		this.kills = new ArrayList<>();
		this.winner = false;
		initializeGame();
	}
	
	public void startGame() {
		
		System.out.println("starting the game");

		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  

		int count = 0;
		
		while (count < 30 && !this.winner) {
			
			Player player = players.pollFirst();

			int pos1 = -1;
			int pos2 = -1;
			
			while (true) {
				System.out.println("Player : " + player.name +", enter the values of pos1 and pos2 : ");
				System.out.println(" enter pos1 : ");
				pos1 = sc.nextInt();
				System.out.println(" enter pos2 : ");
				pos2 = sc.nextInt();
				
				boolean valid = board.isValidMove(pos1, pos2, player.color);
				if (valid) {
					break;
				}
			}
			
			Piece p1 = board.getPiece(pos1);
			Piece p2 = board.getPiece(pos2);
			
			Move move = new Move(player.id, p1, pos1, pos2);
			this.moves.add(move);
			board.setPiece(pos1, pos2, p1);
			count++;

			if (p2 != null) {
				this.kills.add( new Kill(move, p1, p2));
				
				if (p2.type == PieceType.K) {
					this.winner = true;
				}
			}
			
			board.printBoard();
			
			if (this.winner) {
				System.out.println(" Player " + player.id + " has won the game");
				break;
			}
			else {
				players.addLast(player);
			}
		}
		
		if (!this.winner) {
			System.out.println(" Match has been drawn b/w players"  );
		}
		
		printMoves();
		
		printKills();
		
		board.printBoard();
	}


	private void printKills() {

		System.out.println(" \n \n Kills by the players :- ");
		for (Kill kill : this.kills) {
			System.out.println(kill);
		}
		System.out.println();
	}

	private void printMoves() {
		
		System.out.println(" \n \n Moves by the players :- ");
		for (Move move : this.moves) {
			System.out.println(move);
		}
		System.out.println();
	}
	

	private void initializeGame() {
		
		this.players.add(new Player(1, "p1", PieceColor.W));
		this.players.add(new Player(2, "p2", PieceColor.B));
		
		// filling white cells
		for (int i=0;i<16;i++) {
			if (i==0 || i==7) {
				board.setPiece(i, new WhiteElephant());
			}
			else if (i==1 || i==6) {
				board.setPiece(i, new WhiteCamel());
			}
			else if (i==2 || i==5) {
				board.setPiece(i, new WhiteHorse());
			}
			else if (i==3) {
				board.setPiece(i, new WhiteKing());
			}
			else if (i==4) {
				board.setPiece(i, new WhiteQueen());

			}
			else {
				board.setPiece(i, new WhitePawn());
			}
		}
		
		// filling black cells
		for (int i=48;i<64;i++) {
			if (i==56 || i==63) {
				board.setPiece(i, new BlackElephant());
			}
			else if (i==57 || i==62) {
				board.setPiece(i, new BlackCamel());
			}
			else if (i==58 || i==61) {
				board.setPiece(i, new BlackHorse());
			}
			else if (i==59) {
				board.setPiece(i, new BlackKing());
			}
			else if (i==60) {
				board.setPiece(i, new BlackQueen());
			}
			else {
				board.setPiece(i, new BlackPawn());
			}
		}
		
		board.printBoard();
	}
	
	
	
}
