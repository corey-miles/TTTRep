package com.miles.cpu;

/**
 * Interface for all levels and iterations of computers for Tic Tac Toe.
 * 
 * @author corey
 *
 */
public interface Computer {
	
	/**
	 * Calculates where the current computer should move.
	 * 
	 * @return Computer's move
	 */
	public int move(char[] board);
	
}
