package com.practice.lld.Chess;

public class BlackCamel extends Piece {

	public BlackCamel() {
		super(PieceColor.B, PieceType.C);
	}

	@Override
	public boolean validateMove(int pos1, int pos2) {
		return false;
	}

}
