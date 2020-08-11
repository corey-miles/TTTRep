package com.miles.cpu;

import java.util.Random;

/**
 * Novice implementation for Tic Tac Toe computer.
 * Uses randomized move choices: The next spot it finds, it will move. 
 * 
 * @author Corey Miles
 *
 */
public class NoviceComputer implements Computer {
	
	private Random RANDOM = new Random();

	@Override
	public int move(char[] board) {

		// USING INT AS BOOLEAN
		int move = -1;
		while (move < 0) {
			// INITIAL SPOT
			move = RANDOM.nextInt(9);
			
			// CATCH TAKEN SPOT
			if (board[move] != ' ') {
				move = -1;
			}
		}
		
		// RETURN
		return move;
		
	}

}
