package com.practice.lld.Chess;

public class BlackPawn extends Piece {

	public BlackPawn() {
		super(PieceColor.B, PieceType.P);
	}

	@Override
	public boolean validateMove(int pos1, int pos2) {
		return false;
	}

}
