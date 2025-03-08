package com.practice.lld.Chess;

public class Board {
	
	int n;
	Cell[][] cells;
	
	public Board() {
		this.n = 8;
		this.cells = new Cell[8][8];
		initiatzeCells();
	}

	private void initiatzeCells() {
		
		for (int i=0;i<this.n;i++) {
			for (int j=0;j<this.n;j++) {
				this.cells[i][j] = new Cell(i, j);
			}
		}
	}
	
	public void setPiece(int pos, Piece piece) {
		int x = pos/this.n;
		int y = pos%this.n;
		cells[x][y].piece = piece;
	}
	
	public void setPiece(int pos1, int pos2, Piece p1) {
		int x1 = pos1/this.n;
		int y1 = pos1%this.n;
		cells[x1][y1].piece = null;
		
		int x2 = pos2/this.n;
		int y2 = pos2%this.n;
		cells[x2][y2].piece = p1;
	}
	
	public Piece getPiece(int pos) {
		int x = pos/this.n;
		int y = pos%this.n;
		return this.cells[x][y].piece;
	}
	
	public void printBoard() {
		
		System.out.println(" printin the board");
		for (int i=0;i<this.n;i++) {
			for (int j=0;j<this.n;j++) {
				System.out.print(this.cells[i][j].getCellValue() + "  ");
			}
			System.out.println("");
		}
		
		System.out.println("\n");
	}
	
	public boolean isValidMove(int pos1, int pos2, PieceColor color) {
		Piece p1 = getPiece(pos1);
		if (p1 == null || p1.color != color) {
			return false;
		}
		
		Piece p2 = getPiece(pos2);
		if (p2 != null && p2.color == color) {
			return false;
		}
		
		return true;
	}
}
