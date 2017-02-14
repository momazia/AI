package com.sc.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sc.main.chessman.Chessman;

public class State {

	private int boardSize;
	private List<Chessman> chessmen;

	public State(int boardSize, Chessman... chessmen) {
		super();
		this.boardSize = boardSize;
		this.chessmen = Arrays.asList(chessmen);
	}

	public List<Chessman> getChessmen() {
		return chessmen;
	}

	public List<State> getPossibleStates() throws InstantiationException, IllegalAccessException {
		List<State> result = new ArrayList<>();
		for (Chessman currentChessman : chessmen) {
			List<Chessman> victims = currentChessman.getPossibleVictims(chessmen, boardSize);
			if (!victims.isEmpty()) {
				List<State> newStates = createNewStates(currentChessman, victims);
				if (!newStates.isEmpty()) {
					result.addAll(newStates);
				}
			}
		}
		return result;
	}

	private List<State> createNewStates(Chessman currentChessman, List<Chessman> victims) throws InstantiationException, IllegalAccessException {
		List<State> result = new ArrayList<>();
		for (Chessman victim : victims) {
			// Getting all the other chessmen than the current chessman and the victim.
			List<Chessman> otherChessmen = getOtherChessmen(currentChessman, victim);
			// Moving the current chessman to the victims location
			Chessman newChessman = getNewChessman(currentChessman, victim);
			// Adding all the chessmen together
			otherChessmen.add(newChessman);
			result.add(new State(boardSize, otherChessmen.toArray(new Chessman[0])));
		}
		return result;
	}

	public Chessman getNewChessman(Chessman currentChessman, Chessman victim) throws InstantiationException, IllegalAccessException {
		Chessman newChessman = currentChessman.getClass().newInstance();
		newChessman.setLocation(victim.getLocation());
		return newChessman;
	}

	public List<Chessman> getOtherChessmen(Chessman currentChessman, Chessman victim) {
		List<Chessman> result = new ArrayList<>();
		for (Chessman chessman : chessmen) {
			if (!chessman.equals(currentChessman) && !chessman.equals(victim)) {
				result.add(chessman);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (Chessman chessman : chessmen) {
			str.append(chessman.toString() + " ");
		}
		return str.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;

		if (!(o instanceof State)) {
			return false;
		}

		State state = (State) o;
		return state.getChessmen().size() == getChessmen().size() && state.getChessmen().containsAll(getChessmen());
	}

	public boolean isGoal() {
		return chessmen.size() <= 1;
	}
}
