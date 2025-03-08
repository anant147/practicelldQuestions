package com.practice.lld.Chess;

public class Cell {
	
	int x;
	int y;
	int pos;
	Piece piece;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.pos = x*8+y;
	}
	
	public String getCellValue() {
		String cellValue = this.piece != null ? (this.piece.color.toString() + this.piece.type.toString()) : "XX";
		String s = this.pos + cellValue;
		return s.length() == 4 ? s : (0+s);
	}
}
