package com.practice.lld.Chess;

public class Move {
	
	int pid;
	Piece piece;
	int stpos;
	int endpos;
	
	Move(int pid, Piece piece, int stpos, int endpos){
		this.pid = pid;
		this.piece = piece;
		this.stpos = stpos;
		this.endpos = endpos;
	}

	@Override
	public String toString() {
		return "Move [pid=" + pid + ", piece=" + piece + ", stpos=" + stpos + ", endpos=" + endpos + "]";
	}
}
