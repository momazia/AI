package com.marblesolitaire.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.marblesolitaire.engine.Engine;
import com.marblesolitaire.engine.Frontier;

/**
 * A custom engine for Marble Solitaire puzzle.
 * 
 * @author Mahdi Ziaee
 *
 */
public class MarbleSolitaireEngine extends Engine<MarbleSolitaireState> {

	public static final String IO_DEFAULT_TXT = "./io/default.txt";
	private String filePath;

	public MarbleSolitaireEngine(Frontier<MarbleSolitaireState> frontier) {
		super(frontier);
	}

	/**
	 * Creates the initial state by reading the content of the file path given. 'O' represents a marble, ' ' represents an empty spot and anything
	 * else like 'X' is the blocked spot.
	 * 
	 * @param boardFilePath
	 * @return
	 */
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

	/**
	 * Read the content of the file name given line by line.
	 * 
	 * @param fileName
	 * @return
	 */
	private List<String> readFile(String fileName) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			return br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MarbleSolitaireState createInitialState() {
		return createInitialState(filePath);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
