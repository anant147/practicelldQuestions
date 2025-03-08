package com.practice.lld.Chess;

public abstract class Piece {
	PieceColor color;
	PieceType type;
	
	public Piece(PieceColor color, PieceType type) {
		this.color = color;
		this.type = type;
	}
	
	public abstract boolean validateMove(int pos1, int pos2);

	@Override
	public String toString() {
		return this.color.toString() + this.type.toString();
	}
}
