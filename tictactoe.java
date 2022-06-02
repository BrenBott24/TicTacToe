import java.awt.*;
import java.util.*; 
public class tictactoe {

	private static int state[] = new int[9]; 

	public static void main (String[] args) {
		StdDraw.setCanvasSize(600,600);

		int t = 100; 
		StdDraw.enableDoubleBuffering();
		Game a = new Game(new Player("X"),new Player("o")); 

		while(true) {
			boolean mouse = false; 
			StdDraw.setPenColor(Color.BLACK); 
			StdDraw.clear(Color.PINK);
			StdDraw.line(.425, .4, .425, .9); //left vertical
			StdDraw.line(.675, .4, .675, .9); //right vertical
			StdDraw.line(.25, .55, .85, .55); //top
			StdDraw.line(.25, .75, .85, .75); //bottom

			if(StdDraw.isMousePressed()) {
				mouse = true; 
			}
			if(mouse && StdDraw.mouseX()>.7) {

				if(StdDraw.mouseY()>.75) {

					state[2] = 2; 
				}
				else if(StdDraw.mouseY()>.55) {

					state[5] = 2; 
				}
				else if(StdDraw.mouseY()>.4){

					state[8] = 2; 
				}

			}
			else if(mouse && StdDraw.mouseX()>.43) {
				if(StdDraw.mouseY()>.75) {

					state[1] = 2; 

				}
				else if(StdDraw.mouseY()>.55) {

					state[4] = 2; 
				}
				else if(StdDraw.mouseY()>.4){

					state[7] = 2; 
				}

			}
			else if(mouse && StdDraw.mouseX()>.23) {
				if(StdDraw.mouseY()>.75) {
					state[0] = 2; 
				}
				else if(StdDraw.mouseY()>.55) {
					state[3] = 2; 
				}
				else if(StdDraw.mouseY()>.4){
					state[6] = 2; 
				}

			}

			// Drawer
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

//			// Circles
//			if(mouse && StdDraw.mouseX()>.7) {
//
//				if(StdDraw.mouseY()>.75) {
//
//					state[2] = 1; 
//				}
//				else if(StdDraw.mouseY()>.55) {
//
//					state[5] = 1; 
//				}
//				else if(StdDraw.mouseY()>.4){
//
//					state[8] = 1; 
//				}
//
//			}
//			else if(mouse && StdDraw.mouseX()>.43) {
//				if(StdDraw.mouseY()>.75) {
//
//					state[1] = 1; 
//
//				}
//				else if(StdDraw.mouseY()>.55) {
//
//					state[4] = 1; 
//				}
//				else if(StdDraw.mouseY()>.4){
//
//					state[7] = 1; 
//				}
//
//			}
//			else if(mouse && StdDraw.mouseX()>.23) {
//				if(StdDraw.mouseY()>.75) {
//					state[0] = 1; 
//				}
//				else if(StdDraw.mouseY()>.55) {
//					state[3] = 1; 
//				}
//				else if(StdDraw.mouseY()>.4){
//					state[6] = 1; 
//				}
//
//			}
//
//			// Drawer
//			for(int i= 0; i< state.length; i++) {
//				if(state[0] ==1) {
//					StdDraw.circle(.35, .85, .05);
//				}
//				if(state[1] ==1) {
//					StdDraw.circle(.55, .85, .05);
//				}
//				if(state[2] ==1) {
//					StdDraw.circle(.75, .85, .05);
//				}
//				if(state[3] ==1) {
//					StdDraw.circle(.35, .65, .05);
//				}
//				if(state[4] ==1) {
//					StdDraw.circle(.55, .65, .05);
//				}
//				if(state[5] ==1) {
//
//					StdDraw.circle(.75, .65, .05);
//				}
//				if(state[6] ==1 ) {
//					StdDraw.circle(.35, .45, .05);
//				}
//				if(state[7] ==1) {
//					StdDraw.circle(.55, .45, .05);
//
//				}
//				if(state[8] ==1) {
//
//					StdDraw.circle(.75, .45, .05);
//				}

				StdDraw.show(); 

			}

//		}

	}
}
