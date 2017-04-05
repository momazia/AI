package com.marblesolitaire.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

	public static final String IO_DEFAULT_TXT = "./io/default.txt";

	private Frontier frontier;

	public Engine() {
		initiate(IO_DEFAULT_TXT);
	}

	public Engine(String boardFilePath) {
		initiate(boardFilePath);
	}

	private void initiate(String boardFilePath) {
		MarbleSolitaireState initialState = createInitialState(boardFilePath);
		frontier.add(initialState);
	}

	/**
	 * Uses the frontier class to create a new instance of the frontier.
	 * 
	 * @param frontierClass
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Engine(Class<? extends Frontier> frontierClass) throws InstantiationException, IllegalAccessException {
		frontier = frontierClass.newInstance();
	}

	public MarbleSolitaireState createInitialState(String boardFilePath) {
		List<String> lines = readFile(boardFilePath);
		int boardSize = lines.size();
		MarbleSolitaireState initialState = new MarbleSolitaireState(boardSize);
		for (int i = boardSize - 1; i >= 0; i--) {
			for (int j = 0; j < boardSize; j++) {
				if (lines.get(i).charAt(j) == 'O') {
					initialState.setSpot(j, (boardSize - 1) - i, true);
				} else if (lines.get(i).charAt(j) == ' ') {
					initialState.setSpot(j, (boardSize - 1) - i, false);
				}
			}
		}
		return initialState;
	}

	private List<String> readFile(String fileName) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			return br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
