package com.miles.game;
import java.util.Scanner;

import com.miles.cpu.Computer;

public class Game {
	
	private char[] board;
	private boolean gameover;
	private char winner;
	private Computer cpu;
	
	private int[][] WIN = new int[][] {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
		{1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
		
	private Scanner SCANNER = new Scanner(System.in);
	
	/**
	 * Constructor.
	 */
	public Game(Computer c) {
		// INITIALIZE EVERYTHING
		board = new char[9];
		for (int i = 0; i < board.length; i++) {board[i] = ' ';}
		gameover = false;
		winner = ' ';
		cpu = c;
		
		// START THE GAME
		start();
	}
	
	/**
	 * Start the game of Tic-Tac-Toe
	 */
	private void start() {
		// INITIAL PRINT
		print();
		
		int i = 1;
		while (!gameover) {
			// MOVE
			if (i > 0) {playerMove();}
			else {board[cpu.move(board)] = 'o';}
			
			// PRINT
			print();
			
			// CYCLE
			i *= -1;
			
			// CHECK
			gameover = isMatched();			
		}
		
		System.out.println("Winner: " + winner);
	}
	
	/**
	 * Prints off the current layout of the Tic-Tac-Toe board.
	 */
	private void print() {
		// ITERATE THROUGH ROW
		for (int i = 0; i < board.length; i += 3) {
			// CREATE ROW
			String s = "";
			s += board[i];
			s += " | ";
			s += board[i+1];
			s += " | ";
			s += board[i+2];
			System.out.println(s);
			
			// HORIZONTAL LINE
			if (i+3!=board.length) {
				System.out.println("---------");
			}
		}
		
		// EXTRA BLANK LINE
		System.out.println();
	}

	/**
	 * Prompts user for move (self-validating).
	 */
	private void playerMove() {
		// USING INT AS BOOLEAN
		int move = -1;
		while (move < 0) {
			
			// COLLECT INPUT
			System.out.print("Enter spot[1-9]: ");
			try {
				move = Integer.parseInt(SCANNER.nextLine()) - 1;
				
				// CATCH TAKEN SPOT
				if (board[move] != ' ') {
					System.out.println("ERROR - Spot Taken");
					move = -1;
					
				// CATCH INVALID STOT
				} else if (move < 0 || move > 8) {
					System.out.println("ERROR - Invalid Spot");
					move = -1;
				}
				
			// CATCH INVALID INPUT
			} catch (NumberFormatException e) {
				System.out.println("ERROR - Invalid Input");
			}
		}
		
		// SUBMIT MOVE ONCE DONE
		board[move] = 'x';
		
		// CHECK IF MATCH
		gameover = isMatched();
	}
	
	/**
	 * Checks if the game is 
	 * @return
	 */
	private boolean isMatched() {
		boolean match = false;
		int i = 0;
		
		// ITERATE THROUGH POSSIBLE WINS
		while (i < WIN.length && !match) {
			// GET ARRAY OF SPOTS
			int[] spots = WIN[i];
			
			// VERIFY NOT BLANK AND ALL ARE THE SAME
			match = ' ' != board[spots[0]] && board[spots[0]] == board[spots[1]] && board[spots[1]] == board[spots[2]];
			
			// INCREMENT 'i' FOR NEXT SPOTS
			i++;
		}
		
		// GET WINNING char IF NEEDED
		if (match) {
			// GO BACK TO CORRECT POSITION
			i--;
			// GET char
			winner = board[WIN[i][0]];
		}
		
		return match;
	}

}
