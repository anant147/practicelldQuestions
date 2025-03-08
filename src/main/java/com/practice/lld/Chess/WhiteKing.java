package com.practice.lld.Chess;

public class WhiteKing extends Piece {

	public WhiteKing() {
		super(PieceColor.W, PieceType.K);
	}

	@Override
	public boolean validateMove(int pos1, int pos2) {
		return false;
	}

}
