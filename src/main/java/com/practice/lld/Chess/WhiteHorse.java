package com.practice.lld.Chess;

public class WhiteHorse extends Piece {

	public WhiteHorse() {
		super(PieceColor.W, PieceType.H);
	}

	@Override
	public boolean validateMove(int pos1, int pos2) {
		return false;
	}

}
