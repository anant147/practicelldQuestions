package com.practice.lld.Chess;

public class Kill {
	
	Move move;
	Piece killer;
	Piece killed;

	public Kill(Move move, Piece p1, Piece p2) {
		this.move = move;
		this.killer = p1;
		this.killed = p2;
	}

	@Override
	public String toString() {
		return "Kill [move=" + move + ", killer=" + killer + ", killed=" + killed + "]";
	}

}
