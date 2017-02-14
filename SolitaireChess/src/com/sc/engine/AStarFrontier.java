package com.sc.engine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.sc.main.chessman.Bishop;
import com.sc.main.chessman.Chessman;
import com.sc.main.chessman.King;
import com.sc.main.chessman.Knight;
import com.sc.main.chessman.Pawn;
import com.sc.main.chessman.Queen;
import com.sc.main.chessman.Rook;

public class AStarFrontier implements Frontier {

	private PriorityQueue<State> states;

	private static Map<Class<? extends Chessman>, Integer> heuristicMap = null;

	static {
		heuristicMap = new HashMap<>();
		heuristicMap.put(Queen.class, 11);
		heuristicMap.put(King.class, 8);
		heuristicMap.put(Rook.class, 6);
		heuristicMap.put(Bishop.class, 5);
		heuristicMap.put(Knight.class, 4);
		heuristicMap.put(Pawn.class, 2);
	}

	public AStarFrontier() {
		states = new PriorityQueue<>(new Comparator<State>() {

			@Override
			public int compare(State o1, State o2) {
				Integer o1Total = calculateTotalScore(o1.getChessmen());
				Integer o2Total = calculateTotalScore(o2.getChessmen());
				return o1Total.compareTo(o2Total);
			}

			private Integer calculateTotalScore(List<Chessman> chessmen) {
				Integer result = 0;
				for (Chessman chessman : chessmen) {
					result += heuristicMap.get(chessman.getClass());
				}
				return result;
			}
		});

	}

	@Override
	public State pop() {
		return states.poll();

	}

	@Override
	public void addState(State state) {
		states.add(state);
	}

	@Override
	public boolean isEmpty() {
		return states.isEmpty();
	}

}
