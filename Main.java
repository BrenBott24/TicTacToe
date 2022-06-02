import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Game tictactoe;
	private static Player first;
	private static Player second;
	private static ArrayList<String> moves = new ArrayList<String>();
	private static int count = 0;

	public static void main(String[] args) {
		moves = createArrayList();
		
		Scanner k = new Scanner(System.in);
		
		// Prompt the User if they'd like to play
		System.out.println("Would you like to play a game of TicTacToe? (yes or no)");
		String answer = k.nextLine();
		if (answer.equalsIgnoreCase("yes")) {
			// There will be a prompt to play against a computer later
			System.out.println("Would you like to be Xs or Os?");
			String p = k.nextLine();
			
			if (p.equalsIgnoreCase("X")) {
				first = new Player(p);
				second = new Player("O");
				tictactoe = new Game(second, first);
				System.out.println("Player 1 is now \"X\" and Player 2 is now \"O\".\n");
			}
			else if (p.equalsIgnoreCase("O")) {
				first = new Player(p);
				second = new Player("X");
				tictactoe = new Game(first, second);
				System.out.println("Player 1 is now \"O\" and Player 2 is now \"X\".\n");
			}
			else {
				System.out.println("Invalid. Please select \"X\" or \"O\" and not " + p);
			}
			
			System.out.println("We will now begin the game. Tic Tac Toe has simple rules, rules which should be easily followed. In order to win against your opponent,\n"
					+ "you must get three of your own letter in a consecutive row (diagonally, horizontally, or vertically). The moves that can be made are as follows:\n"
					+ "Top Left, Top Middle, Top Right, Middle Left, Middle, Middle Right, Bottom Left, Bottom Middle, Bottom Right. Good luck!\n");
			tictactoe.getBoard();
			System.out.println(); 
			
			// Loop back through while the move is invalid
			
			while (tictactoe.hasPlayerWon() == false && count < 8) {
				if (count % 2 == 0) {
					System.out.println("------------------------------");
					System.out.println("Where would you like to move Player 1?");
					String move = k.nextLine();
					boolean check = false;
					for (int i = 0; i < moves.size(); i++) {
						if (moves.get(i).equalsIgnoreCase(move)) {
							check = true;
							moves.remove(i);
						}
					}
					
					if (check == true) {
						tictactoe.makeMove(first, move);
						System.out.println();
						tictactoe.getBoard(); // Display the new board orientation
						System.out.println();
						count++;
					}
					
					else {
						System.out.println("Move invalid, please choose another space.\n");
					}
					
				}
				
				if (tictactoe.hasPlayerWon() == true) {
					System.out.println("Player 1 has won the game!");
					break;
				}
				
				if (count % 2 == 1) {
					System.out.println("------------------------------");
					System.out.println("Where would you like to move Player 2?");
					String diffMove = k.nextLine();
					boolean check = false;
					for (int i = 0; i < moves.size(); i++) {
						if (moves.get(i).equalsIgnoreCase(diffMove)) {
							check = true;
							moves.remove(i);
						}
					}
					
					if (check == true) {
						tictactoe.makeMove(second, diffMove);
						System.out.println();
						tictactoe.getBoard(); // Display the new board orientation
						System.out.println();
						count++;
					}
					
					else {
						System.out.println("Move Invalid, please choose another space.\n");
					}
					
				}
				
				
				if (tictactoe.hasPlayerWon() == true) {
					System.out.println("Player 2 has won!");
					break;
				}
				
			}
			if (tictactoe.hasPlayerWon() == false && count == 8) {
				System.out.println("Where would you like to move Player 1?");
				String move = k.nextLine();
				tictactoe.makeMove(first, move);
				System.out.println();
				tictactoe.getBoard(); // Display the new board orientation
				System.out.println();
				count++;
			}
			
			if (tictactoe.hasPlayerWon() == true && count == 9) {
				System.out.println("Player 1 has won the game!");
			}
			
			else if (count == 9 && tictactoe.hasPlayerWon() == false){
				System.out.println("Tie Game!");
			}
		}
		
		else {
			System.out.println("Come back soon!");
		}
	}
	
	public static ArrayList<String> createArrayList() {
		moves.add("Top Left");
		moves.add("Top Middle");
		moves.add("Top Right");
		moves.add("Middle Left");
		moves.add("Middle");
		moves.add("Middle Right");
		moves.add("Bottom Left");
		moves.add("Bottom Middle");
		moves.add("Bottom Right");
		
		return moves;
	}

}
