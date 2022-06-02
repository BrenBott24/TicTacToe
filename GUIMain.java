import java.awt.*;
import java.util.*;

public class GUIMain {

	private static ArrayList<String> moves = new ArrayList<String>();
	private static Player one = new Player("X");
	private static Player two = new Player("O");
	private static int state[] = new int[9];

	public static void main(String[] args) {
		// Process:
		moves = createArrayList();

		// Create the game
		Game play = new Game(one, two);

		// Create the actual tictactoe board
		StdDraw.setCanvasSize(600,600);
		StdDraw.enableDoubleBuffering();

		StdDraw.setPenColor(Color.BLACK); 
		StdDraw.clear(Color.PINK);
		StdDraw.line(.425, .4, .425, .9); //left vertical
		StdDraw.line(.675, .4, .675, .9); //right vertical
		StdDraw.line(.25, .55, .85, .55); //top
		StdDraw.line(.25, .75, .85, .75); //bottom

		StdDraw.show();

		// Create and initialize the needed variables
		int counter = 0;

		// Step 1: Create the board and the new game
		while (play.hasPlayerWon() == false && counter < 8) {

			// Step 2: Play the game
			// Check first player
			if (counter % 2 == 0) {
				boolean mouse = false;
				if (StdDraw.isMousePressed()) {
					mouse = true;
					String move = "";

					// Check the right column
					if(mouse && StdDraw.mouseX()>.7) {
						if(StdDraw.mouseY()>.75) {
							state[2] = 2;
							move = "Top Right";
						}
						else if(StdDraw.mouseY()>.55) {
							state[5] = 2;
							move = "Middle Right";
						}
						else if(StdDraw.mouseY()>.4){
							state[8] = 2; 
							move = "Bottom Right";
						}

					}

					// Check the middle column
					else if(mouse && StdDraw.mouseX()>.43) {
						if(StdDraw.mouseY()>.75) {
							state[1] = 2; 
							move = "Top Middle";

						}
						else if(StdDraw.mouseY()>.55) {
							state[4] = 2;
							move = "Middle";
						}
						else if(StdDraw.mouseY()>.4){
							state[7] = 2;
							move = "Bottom Middle";
						}

					}

					// Check the left column
					else if(mouse && StdDraw.mouseX()>.23) {
						if(StdDraw.mouseY()>.75) {
							state[0] = 2; 
							move = "Top Left";
						}
						else if(StdDraw.mouseY()>.55) {
							state[3] = 2; 
							move = "Middle Left";
						}
						else if(StdDraw.mouseY()>.4){
							state[6] = 2; 
							move = "Bottom Left";
						}
					}

					boolean check = false;
					for (int i = 0; i < moves.size(); i++) {
						if (moves.get(i).equalsIgnoreCase(move)) {
							check = true;
							moves.remove(i); // Basically this move is no longer possible to make
						}
					}

					if (check == true) {
						play.makeMove(one, move);
						for(int i= 0; i< state.length; i++) {
							if(state[0] ==2) {
								StdDraw.line(.3, .9, .4, .8);
								StdDraw.line(.4, .9, .3, .8);
							}
							if(state[1] ==2) {
								StdDraw.line(.5, .9, .6, .8);
								StdDraw.line(.6, .9, .5, .8);
							}
							if(state[2] ==2) {
								StdDraw.line(.8, .9, .7, .8);
								StdDraw.line(.7, .9, .8, .8);
							}
							if(state[3] ==2) {
								StdDraw.line(.3, .6, .4, .7);
								StdDraw.line(.4, .6, .3, .7);
							}
							if(state[4] ==2) {
								StdDraw.line(.5, .6, .6, .7);
								StdDraw.line(.6, .6, .5, .7);
							}
							if(state[5] ==2) {
								StdDraw.line(.8, .6, .7, .7);
								StdDraw.line(.7, .6, .8, .7);
							}
							if(state[6] ==2) {
								StdDraw.line(.3, .5, .4, .4);
								StdDraw.line(.4, .5, .3, .4);
							}
							if(state[7] ==2) {
								StdDraw.line(.5, .5, .6, .4);
								StdDraw.line(.6, .5, .5, .4);
							}
							if(state[8] ==2) {
								StdDraw.line(.8, .5, .7, .4);
								StdDraw.line(.7, .5, .8, .4);
							}
						}

						StdDraw.show();
						counter++;
					}

					else {
						StdDraw.text(.5, .2, "Invalid space, please select a new spot.");
					}
				}
			}

			// Check to see if someone has won
			if (play.hasPlayerWon() == true) {
				StdDraw.text(.5, .3, "Player 1 has won the game!");
				break;
			}


			// Check player two
			if (counter % 2 == 1) {
				boolean mouse = false;
				if (StdDraw.isMousePressed()) {
					mouse = true;
					String move = "";

					// Check the right column
					if(mouse && StdDraw.mouseX()>.7) {
						if(StdDraw.mouseY()>.75) {
							state[2] = 1;
							move = "Top Right";
						}
						else if(StdDraw.mouseY()>.55) {
							state[5] = 1;
							move = "Middle Right";
						}
						else if(StdDraw.mouseY()>.4){
							state[8] = 1; 
							move = "Bottom Right";
						}

					}

					// Check the middle column
					else if(mouse && StdDraw.mouseX()>.43) {
						if(StdDraw.mouseY()>.75) {
							state[1] = 1; 
							move = "Top Middle";

						}
						else if(StdDraw.mouseY()>.55) {
							state[4] = 1;
							move = "Middle";
						}
						else if(StdDraw.mouseY()>.4){
							state[7] = 1;
							move = "Bottom Middle";
						}

					}

					// Check the left column
					else if(mouse && StdDraw.mouseX()>.23) {
						if(StdDraw.mouseY()>.75) {
							state[0] = 1; 
							move = "Top Left";
						}
						else if(StdDraw.mouseY()>.55) {
							state[3] = 1; 
							move = "Middle Left";
						}
						else if(StdDraw.mouseY()>.4){
							state[6] = 1; 
							move = "Bottom Left";
						}
					}

					boolean check = false;
					for (int i = 0; i < moves.size(); i++) {
						if (moves.get(i).equalsIgnoreCase(move)) {
							check = true;
							moves.remove(i); // Basically this move is no longer possible to make
						}
					}

					if (check == true) {
						play.makeMove(two, move);
						for(int i= 0; i< state.length; i++) {
							if(state[0] ==1) {
								StdDraw.circle(.35, .85, .05);
							}
							if(state[1] ==1) {
								StdDraw.circle(.55, .85, .05);
							}
							if(state[2] ==1) {
								StdDraw.circle(.75, .85, .05);
							}
							if(state[3] ==1) {
								StdDraw.circle(.35, .65, .05);
							}
							if(state[4] ==1) {
								StdDraw.circle(.55, .65, .05);
							}
							if(state[5] ==1) {

								StdDraw.circle(.75, .65, .05);
							}
							if(state[6] ==1 ) {
								StdDraw.circle(.35, .45, .05);
							}
							if(state[7] ==1) {
								StdDraw.circle(.55, .45, .05);

							}
							if(state[8] ==1) {

								StdDraw.circle(.75, .45, .05);
							}

							StdDraw.text(.5, .3, "Counter: " + counter);
							StdDraw.show();
							counter++;
						}
					}

					else {
						StdDraw.text(.5, .2, "Invalid space, please select a new spot.");
					}
				}
			}
			
			if (play.hasPlayerWon() == true) {
				StdDraw.text(.5, .3, "Player 2 has won the game!");
				break;
			}

		}

	}

	//	if(mouse && StdDraw.mouseX()>.7) {
	//		
	//		if(StdDraw.mouseY()>.75) {
	//
	//			state[2] = 1; 
	//		}
	//		else if(StdDraw.mouseY()>.55) {
	//
	//			state[5] = 1; 
	//		}
	//		else if(StdDraw.mouseY()>.4){
	//
	//			state[8] = 1; 
	//		}
	//
	//	}
	//	else if(mouse && StdDraw.mouseX()>.43) {
	//		if(StdDraw.mouseY()>.75) {
	//
	//			state[1] = 1; 
	//
	//		}
	//		else if(StdDraw.mouseY()>.55) {
	//
	//			state[4] = 1; 
	//		}
	//		else if(StdDraw.mouseY()>.4){
	//
	//			state[7] = 1; 
	//		}
	//
	//	}
	//	else if(mouse && StdDraw.mouseX()>.23) {
	//		if(StdDraw.mouseY()>.75) {
	//			state[0] = 1; 
	//		}
	//		else if(StdDraw.mouseY()>.55) {
	//			state[3] = 1; 
	//		}
	//		else if(StdDraw.mouseY()>.4){
	//			state[6] = 1; 
	//		}
	//
	//	}
	//
	//	// Drawer
	//		for(int i= 0; i< state.length; i++) {
	//			if(state[0] ==1) {
	//				StdDraw.circle(.35, .85, .05);
	//			}
	//			if(state[1] ==1) {
	//				StdDraw.circle(.55, .85, .05);
	//			}
	//			if(state[2] ==1) {
	//				StdDraw.circle(.75, .85, .05);
	//			}
	//			if(state[3] ==1) {
	//				StdDraw.circle(.35, .65, .05);
	//			}
	//			if(state[4] ==1) {
	//				StdDraw.circle(.55, .65, .05);
	//			}
	//			if(state[5] ==1) {
	//	
	//				StdDraw.circle(.75, .65, .05);
	//			}
	//			if(state[6] ==1 ) {
	//				StdDraw.circle(.35, .45, .05);
	//			}
	//			if(state[7] ==1) {
	//				StdDraw.circle(.55, .45, .05);
	//	
	//			}
	//			if(state[8] ==1) {
	//	
	//				StdDraw.circle(.75, .45, .05);
	//			}
	//	}


	private static ArrayList<String> createArrayList() {
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


