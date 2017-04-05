package com.marblesolitaire.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

	private static final String IO_DEFAULT_TXT = "./io/default.txt";

	private Boolean[][] spots;

	public Board() {
		initiateBoard(IO_DEFAULT_TXT);
	}

	public Board(String boardFilePath) {
		initiateBoard(boardFilePath);
	}

	private void initiateBoard(String boardFilePath) {
		List<String> lines = readFile(boardFilePath);
		int boardSize = lines.size();
		spots = new Boolean[boardSize][boardSize];
		for (int i = boardSize - 1; i >= 0; i--) {
			for (int j = 0; j < boardSize; j++) {
				if (lines.get(i).charAt(j) == 'O') {
					spots[j][(boardSize - 1) - i] = true;
				} else if (lines.get(i).charAt(j) == ' ') {
					spots[j][(boardSize - 1) - i] = false;
				}
			}
		}
	}

	private List<String> readFile(String fileName) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			return br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean[][] getSpots() {
		return spots;
	}

	public void setSpots(Boolean[][] spots) {
		this.spots = spots;
	}

	public Boolean getSpot(int x, int y) {
		return spots[x][y];
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		int boardSize = spots.length;
		for (int y = boardSize - 1; y >= 0; y--) {
			for (int x = 0; x < boardSize; x++) {
				if (Boolean.TRUE.equals(spots[x][y])) {
					result.append("O");
				} else if (Boolean.FALSE.equals(spots[x][y])) {
					result.append(" ");
				} else {
					result.append("X");
				}
			}
			result.append("\n");
		}
		return result.toString();
	}

}
