package com.sc.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sc.main.chessman.Chessman;

/**
 * This class represents a state in the game. It holds a list of the pieces on the board.
 * 
 * @author Mahdi Ziaee
 *
 */
public class State {

	private int boardSize;
	private List<Chessman> chessmen;
	private Integer level;
	private Movement movement;

	public State(int boardSize, Chessman... chessmen) {
		super();
		this.boardSize = boardSize;
		this.chessmen = Arrays.asList(chessmen);
	}

	public State(int boardSize, Movement movement, Chessman... chessmen) {
		super();
		this.boardSize = boardSize;
		this.movement = movement;
		this.chessmen = Arrays.asList(chessmen);
	}

	public State(int boardSize, Integer level, Chessman... chessmen) {
		super();
		this.boardSize = boardSize;
		this.chessmen = Arrays.asList(chessmen);
		this.level = level;
	}

	/**
	 * Finds all the possible states from the current state.
	 * 
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<State> getPossibleStates() throws InstantiationException, IllegalAccessException {
		List<State> result = new ArrayList<>();
		// Finding all the possible victims by looping through all the pieces on the board.
		for (Chessman currentChessman : chessmen) {
			List<Chessman> victims = currentChessman.getPossibleVictims(chessmen, boardSize);
			if (!victims.isEmpty()) {
				// Creating a new state by moving the pieces.
				List<State> newStates = createNewStates(currentChessman, victims);
				if (!newStates.isEmpty()) {
					result.addAll(newStates);
				}
			}
		}
		return result;
	}

	/**
	 * Creates a list of new states by moving the current chessman piece to the victims and taking them down.
	 * 
	 * @param currentChessman
	 * @param victims
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private List<State> createNewStates(Chessman currentChessman, List<Chessman> victims) throws InstantiationException, IllegalAccessException {
		List<State> result = new ArrayList<>();
		for (Chessman victim : victims) {
			// Getting all the other chessmen than the current chessman and the victim.
			List<Chessman> otherChessmen = getOtherChessmen(currentChessman, victim);
			// Moving the current chessman to the victims location
			Chessman newChessman = getNewChessman(currentChessman, victim);
			// Adding all the chessmen together
			otherChessmen.add(newChessman);
			result.add(new State(boardSize, new Movement(currentChessman.getLocation(), newChessman), otherChessmen.toArray(new Chessman[0])));
		}
		return result;
	}

	/**
	 * Moves the current chessman given to victim's location.
	 * 
	 * @param currentChessman
	 * @param victim
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Chessman getNewChessman(Chessman currentChessman, Chessman victim) throws InstantiationException, IllegalAccessException {
		Chessman newChessman = currentChessman.getClass().newInstance();
		newChessman.setLocation(victim.getLocation());
		return newChessman;
	}

	/**
	 * Goes through the list of chessmen on the board and excludes current chessman and the victim from it.
	 * 
	 * @param currentChessman
	 * @param victim
	 * @return
	 */
	public List<Chessman> getOtherChessmen(Chessman currentChessman, Chessman victim) {
		List<Chessman> result = new ArrayList<>();
		for (Chessman chessman : chessmen) {
			if (!chessman.equals(currentChessman) && !chessman.equals(victim)) {
				result.add(chessman);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Level[" + getLevel() + "]: ");
		for (Chessman chessman : chessmen) {
			str.append(chessman.toString() + " ");
		}
		return str.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;

		if (!(o instanceof State)) {
			return false;
		}

		State state = (State) o;
		// Two states are the same if the contain the same list of chessmen.
		return state.getChessmen().size() == getChessmen().size() && state.getChessmen().containsAll(getChessmen());
	}

	/**
	 * If there is only one chessman left on the board, that is the goal. It returns true in this case.
	 * 
	 * @return
	 */
	public boolean isGoal() {
		return chessmen.size() <= 1;
	}

	public List<Chessman> getChessmen() {
		return chessmen;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
}
