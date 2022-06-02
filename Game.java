import java.util.Arrays;

/**
 * Purpose: This class will model the game TicTacToe
 */

public class Game {
	
	// Fields
	private Player pOne;
	private Player pTwo;
	private String[][] grid;
	private int row;
	private int col;
	
	private String Xs = "";
	private String Os = "";
	
	// Constructor
	public Game(Player playerOne, Player playerTwo) {
		pOne = playerOne;
		pTwo = playerTwo;
		grid = new String[3][3];
	}
	
	/**
	 * This method checks if the move the player has made is valid and if so places the correct letter there
	 * 
	 * @param player - The player who made the move
	 * @param move - The move itself
	 */
	public void makeMove(Player player, String place) {
		if (place.equalsIgnoreCase("Top Left")) { // Set the row and column to be the top left position
			row = 0;
			col = 0;
		}
		if (place.equalsIgnoreCase("Top Middle")) { // Set the row and column to be the top middle position
			row = 0;
			col = 1;
		}
		if (place.equalsIgnoreCase("Top Right")) { // Set the row and column to be the top right position
			row = 0;
			col = 2;
		}
		if (place.equalsIgnoreCase("Middle Left")) { // Set the row and column to be the middle left position
			row = 1;
			col = 0;
		}
		if (place.equalsIgnoreCase("Middle")) { // Set the row and column to be the middle position
			row = 1; 
			col = 1;
		}
		if (place.equalsIgnoreCase("Middle Right")) { // Set the row and column to be the middle right position
			row = 1;
			col = 2;
		}
		if (place.equalsIgnoreCase("Bottom Left")) { // Set the row and column to be the bottom left position
			row = 2;
			col = 0;
		}
		if (place.equalsIgnoreCase("Bottom Middle")) { // Set the row and column to be the bottom middle position
			row = 2;
			col = 1;
		}
		if (place.equalsIgnoreCase("Bottom Right")) { // Set the row and column to be the bottom right position
			row = 2;
			col = 2;
		}
		
		// Check if the space is empty
		if (grid[row][col] == null) {
			// For loop to find the place (needs to be a for loop in order to change a value)
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					// Check if the spot is the same
					if (row == i && col == j) {
						// If the player is player 1, then the new value at the spot will be "X"
						if (player.getPlayerLetter().equalsIgnoreCase("X")) {
							grid[row][col] = "X";
						} // Otherwise, the player is player 2 and the new value at the spot will be "O"
						else {
							grid[row][col] = "O";
						}
					}
				}
			}
		}
		// If the space is not empty, tell the user to select another space
		else {
			System.out.println("Invalid move, please choose another space.");
		}
	}
	
	public boolean hasPlayerWon() {
		// Rows
		int countXRows = 0;
		int countORows = 0;
		
		// Columns
		int countXCols = 0;
		int countOCols = 0;;
		
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == "X") { countXRows++; }
				else if (grid[i][j] == "O") { countORows++; }
				if (grid[j][i] == "X") { countXCols++; }
				else if (grid[j][i] == "O") { countOCols++; }
				else {
					break;
				}
			}
			
			if (countXRows == 3) {
				Xs = "X";
				return true;
			}
			else if (countORows == 3) {
				Os = "O";
				return true;
			}
			else if (countXCols == 3) {
				Xs = "X";
				return true;
			}
			else if (countOCols == 3) {
				Os = "O";
				return true;
			}
			else {
				countXRows = 0;
				countORows = 0;
				countXCols = 0;
				countOCols = 0;
			}
		}
		
		// Check diagonal cases
		if ((grid[0][0] == "X" && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) || grid[0][2] == "X" && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
			Xs = "X";
			return true;
		}
		else if ((grid[0][0] == "O" && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) || grid[0][2] == "O" && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
			Os = "O";
			return true;
		}
		
		return false;
	}
	
	public String getX() {
		return Xs;
	}
	
	public String getO() {
		return Os;
	}
	
	public void getBoard() {
		for (String[] a : grid) {
			System.out.println(Arrays.toString(a));
		}
		return;
	}
	
	
	public static void main(String[] args) {
		Player aa = new Player("X");
		Player bb = new Player("O");
		
		Game tic = new Game(aa, bb);
		
		System.out.println("This is the original board");
		tic.getBoard();
		
		System.out.println();
		
		System.out.println("Make a move!");;
		tic.makeMove(aa, "Middle");
		
		System.out.println("\nBoard after a move has been made!");
		tic.getBoard();
		
		System.out.println("\nTest the edge case");
		tic.makeMove(bb, "Middle");
		System.out.println(); // New line breaks
		tic.getBoard();

	}

}
