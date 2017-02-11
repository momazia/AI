package com.sc.engine;

import java.util.ArrayList;
import java.util.List;

import com.sc.main.chessman.Chessman;

public class State {

	private Chessman[] chessmans;

	public State(Chessman... chessmans) {
		super();
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
			List<Chessman> victims = getPossibleVictims(chessman);

		}
		return result;
	}

	public List<Chessman> getPossibleVictims(Chessman chessman) {
		List<Chessman> result = new ArrayList<>();
		for (Chessman boardChessman : chessmans) {
			if (!boardChessman.equals(chessman)) {
				if (chessman.canTakeDown(boardChessman)) {
					result.add(boardChessman);
				}
			}
		}
		return result;
	}
}
