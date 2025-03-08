package com.practice.lld.Chess;

public class BlackElephant extends Piece{

	public BlackElephant() {
		super(PieceColor.B, PieceType.E);
	}

	@Override
	public boolean validateMove(int pos1, int pos2) {
		return false;
	}
	
}
