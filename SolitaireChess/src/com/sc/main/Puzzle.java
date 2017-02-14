package com.sc.main;

import com.sc.engine.Frontier;
import com.sc.main.chessman.Chessman;

/**
 * Represents a puzzle problem.
 * 
 * @author Mahdi Ziaee
 *
 */
public class Puzzle {

	private int boardSize;
	private Chessman[] chessmen;
	private Class<? extends Frontier> frontier;
	private boolean iterative;

	public Puzzle(int boardSize, boolean iterative, Class<? extends Frontier> frontier, Chessman... chessmen) {
		this.boardSize = boardSize;
		this.iterative = iterative;
		this.setFrontier(frontier);
		this.chessmen = chessmen;
	}

	@Override
	public String toString() {
		return "Board size [" + boardSize + "], Iterative [" + iterative + "], Frontier type [" + frontier.getSimpleName() + "]";
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public Chessman[] getChessmen() {
		return chessmen;
	}

	public void setChessmen(Chessman[] chessmen) {
		this.chessmen = chessmen;
	}

	public Class<? extends Frontier> getFrontier() {
		return frontier;
	}

	public void setFrontier(Class<? extends Frontier> frontier) {
		this.frontier = frontier;
	}

	public boolean isIterative() {
		return iterative;
	}

	public void setIterative(boolean iterative) {
		this.iterative = iterative;
	}

}
