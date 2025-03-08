package com.practice.lld.Chess;

public class WhiteQueen extends Piece {

	public WhiteQueen() {
		super(PieceColor.W, PieceType.Q);
	}

	@Override
	public boolean validateMove(int pos1, int pos2) {
		return false;
	}

}
