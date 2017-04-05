package com.marblesolitaire.engine;

public class Engine {

	private Board board;

	public Engine() {
		this.board = new Board();
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
