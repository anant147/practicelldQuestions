package com.practice.lld.Chess;

public class WhiteCamel extends Piece {

	public WhiteCamel() {
		super(PieceColor.W, PieceType.C);
	}

	@Override
	public boolean validateMove(int pos1, int pos2) {
		return false;
	}

}
