package com.sc.engine;

import java.util.ArrayList;
import java.util.List;

import com.sc.main.chessman.Chessman;

public class State {

	private int boardSize;
	private Chessman[] chessmans;

	public State(int boardSize, Chessman... chessmans) {
		super();
		this.boardSize = boardSize;
		this.chessmans = chessmans;
	}

	public Chessman[] getChessmans() {
		return chessmans;
	}

	public void setChessmans(Chessman... chessmans) {
		this.chessmans = chessmans;
	}

	public List<State> getPossibleStates() {
		List<State> result = new ArrayList<>();
		for (Chessman chessman : chessmans) {
			List<Chessman> victims = chessman.getPossibleVictims(chessmans, boardSize);

		}
		return result;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (int y = boardSize; y > 0; y--) {
			for (int x = 1; x <= boardSize; x++) {
				String name = getChessmanName(x, y);
				if (name == null) {
					str.append("\t");
				} else {
					str.append(str);
				}
			}
			str.append("\n");
		}
		return str.toString();
	}

	private String getChessmanName(int x, int y) {
		for (Chessman chessman : chessmans) {
			if (chessman.getLocation().getX() == x && chessman.getLocation().getY() == y) {
				return chessman.getClass().getName();
			}
		}
		return null;
	}

}
