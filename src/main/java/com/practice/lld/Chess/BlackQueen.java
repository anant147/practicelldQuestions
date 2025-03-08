package com.practice.lld.Chess;

public class BlackQueen extends Piece {

	public BlackQueen() {
		super(PieceColor.B, PieceType.Q);
	}

	@Override
	public boolean validateMove(int pos1, int pos2) {
		return false;
	}
}
