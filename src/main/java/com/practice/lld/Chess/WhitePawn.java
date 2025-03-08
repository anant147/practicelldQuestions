package com.practice.lld.Chess;

public class WhitePawn extends Piece{
	
	public WhitePawn() {
		super(PieceColor.W, PieceType.P);
	}

	@Override
	public boolean validateMove(int pos1, int pos2) {
		return false;
	}
}
