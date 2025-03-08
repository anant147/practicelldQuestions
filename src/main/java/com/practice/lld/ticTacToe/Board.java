package com.practice.lld.ticTacToe;

public class Board {
	
	int size;
	PlayingPiece[][] pieces;
	
	public Board(int size) {
		this.size = size;
		pieces = new PlayingPiece[size][size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public PlayingPiece[][] getPieces() {
		return pieces;
	}

	public void setPieces(PlayingPiece[][] pieces) {
		this.pieces = pieces;
	}
}
