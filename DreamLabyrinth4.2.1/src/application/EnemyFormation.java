package application;

import java.util.ArrayList;

import javafx.scene.layout.Pane;

public class EnemyFormation implements Universals {
	
	Sprite enemy;
	String enemyType;
	Pane currentLayer;
	int level;
	
	
	// Constructor for enemy formations, takes type of enemy, layer, and their level
	public EnemyFormation(String newEnemyType, Pane newCurrentLayer, int newLevel) {
		enemyType = newEnemyType;
		currentLayer = newCurrentLayer;
		level = newLevel;
	}
	
	
	/**
	 * 	Makes a circular formation made up of the enemy type
	 * 
	 * @param initialX -> x position from where the radius will start
	 * @param initialY -> y position from where the radius will start
	 * @param radius -> length of radius
	 * @param lowerLimit -> from where circle starts
	 * @param greaterLimit  -> where circle ends
	 * @param spacing  -> space between enemies
	 */
	public void radialFormation(double initialX, double initialY, double radius, double lowerLimit, double greaterLimit, int spacing) {
		
		double radians = Math.toRadians(lowerLimit);
		while (Math.toRadians(greaterLimit) >= radians) {
			switch(enemyType) {
			case("donut"):
				enemy = new Donut(currentLayer, level);
				break;
			case("ice"):
				enemy = new IceCream(currentLayer, level);
				break;
			case("txtbk"):
				enemy = new Textbook(currentLayer, level);
				break;
			case("clock"):
				enemy = new Clock(currentLayer, level);
				break;
			case("flask"):
				enemy = new Flask(currentLayer, level);
				break;
			case("melon"):
				enemy = new Watermelon(currentLayer, level);
				break;
			case("loan"):
				enemy = new StudentLoan(currentLayer, level);
				break;
			}
			enemy.setYpos((Math.sin(radians) * radius) + initialY);
			enemy.setXpos((Math.cos(radians) * radius) + initialX);
			enemies.add(enemy);
			radians += Math.toRadians(spacing);
		}
	}
	
	
	/**
	 * Makes a triangular formation made up of the enemy type
	 * 
	 * @param initialX -> x position from where first base will start 
	 * @param initialY -> y position from where first base will start
	 * @param bases  -> number of rows in the triangle
	 * @param spacing -> space between enemies
	 * @param inverted  -> to make an upside down triangle or not
	 */
	public void triangularFormation(int initialX, int initialY, int bases, int spacing, boolean inverted) {
		
		int x = initialX;
		int count = 0;
		while(bases > 0) {
			for (int i = 0; i < bases; i++) {
				switch(enemyType) {
				case("donut"):
					enemy = new Donut(currentLayer, level);
					break;
				case("ice"):
					enemy = new IceCream(currentLayer, level);
					break;
				case("txtbk"):
					enemy = new Textbook(currentLayer, level);
					break;
				case("clock"):
					enemy = new Clock(currentLayer, level);
					break;
				case("flask"):
					enemy = new Flask(currentLayer, level);
					break;
				case("melon"):
					enemy = new Watermelon(currentLayer, level);
					break;
				case("loan"):
					enemy = new StudentLoan(currentLayer, level);
					break;
				}
				enemy.setXpos(initialX);
				enemy.setYpos(initialY);
				enemies.add(enemy);
				initialX -= spacing;
			}
			count ++;
			if (inverted) { initialY -= spacing; }
			else { initialY += spacing; }
			initialX = x;
			initialX -= (spacing / 2) * count;
			bases--;
		}
	}
	
	

	/**
	 * 	Makes a diagonal formation made up of the enemy type
	 * 
	 * @param initialX -> x position from where the first object will be
	 * @param initialY -? y position from where the first object will be
	 * @param length -> number of rows diagonal will have
	 * @param spacing -> spacing between enemies
	 * @param inverted -> to do a diagonal from left to right or right to left
	 */
	public void diagonalFormation(int initialX, int initialY, int length, int spacing, boolean inverted) {
		if (inverted) { initialX = SCRN_WIDTH - initialX; }
		while(length > 0) {
			switch(enemyType) {
			case("donut"):
				enemy = new Donut(currentLayer, level);
				break;
			case("ice"):
				enemy = new IceCream(currentLayer, level);
				break;
			case("txtbk"):
				enemy = new Textbook(currentLayer, level);
				break;
			case("clock"):
				enemy = new Clock(currentLayer, level);
				break;
			case("flask"):
				enemy = new Flask(currentLayer, level);
				break;
			case("melon"):
				enemy = new Watermelon(currentLayer, level);
				break;
			case("loan"):
				enemy = new StudentLoan(currentLayer, level);
				break;
			}
			enemy.setXpos(initialX);
			enemy.setYpos(initialY);
			enemies.add(enemy);
			if (inverted) { initialX += spacing; initialY -= spacing; }
			else { initialX -= spacing; initialY -= spacing; }
			length --;
		}
	}
	
	
	// Makes a diamond formation made up of the enemy type by calling 
	// the triangle formation inverted and not inverted
	// See triangle for more info on parameters
	public void diamondFormation(int initialX, int initialY, int bases, int spacing) {
		triangularFormation(initialX, initialY, bases, spacing, true);
		triangularFormation(initialX, initialY, bases, spacing, false);
	}
	
	
	// Makes a V formation made up of the enemy type by calling
	// the diagonal formation inverted and not inverted
	// See diagonal for more info on 
	public void vFormation(int initialX, int initialY, int length, int spacing) {
		diagonalFormation(initialX, initialY, length, spacing, true);
		diagonalFormation(initialX - 200, initialY, length, spacing, false);
	}
	
	
	/**
	 * Makes a rectangular formation made up of the enemy type
	 * 
	 * @param initialX -> x position where first row will start
	 * @param initialY -> y position where first row will start
	 * @param bases -> height of rectangle 
	 * @param length -> length of rectangle
	 * @param spacing -> space between enemies
	 */
	public void rectangleFormation(int initialX, int initialY, int bases, int length, int spacing) {
		int x = initialX;
		for (int i = 0; i < bases; i++) {
			for (int j = 0; j < length; j++) {
				switch(enemyType) {
				case("donut"):
					enemy = new Donut(currentLayer, level);
					break;
				case("ice"):
					enemy = new IceCream(currentLayer, level);
					break;
				case("txtbk"):
					enemy = new Textbook(currentLayer, level);
					break;
				case("clock"):
					enemy = new Clock(currentLayer, level);
					break;
				case("flask"):
					enemy = new Flask(currentLayer, level);
					break;
				case("melon"):
					enemy = new Watermelon(currentLayer, level);
					break;
				case("loan"):
					enemy = new StudentLoan(currentLayer, level);
					break;
				}
				enemy.setXpos(initialX);
				enemy.setYpos(initialY);
				enemies.add(enemy);
				initialX += spacing;
			}
			initialX = x;
			initialY += spacing;
		}
	}
	
	
	// Makes an hour glass formation made up of the enemy type by calling
	// triangle formation inverted and not inverted and modifying the intialY position
	// See triangle formation for more info on parameters
	public void hourGlassFormation(int initialX, int initialY, int bases, int length, int spacing) {
		triangularFormation(initialX, initialY, bases, spacing, true);
		triangularFormation(initialX, initialY / 2, bases, spacing, false);
	}	
	
	// Makes a formation I made up
	/**
	 * 
	 * @param centre ->  middle of formation
	 * @param radius -> length of inner radius
	 * @param mainRadius -> length of outer radius
	 * @param limiter -> limiter for inner radius to only make part of a circle
	 * @param spacing -> space between enemies
	 * @param mainSpacing -> space between inner part circles
	 */
	public void unformalFormation(int centre, double radius, double mainRadius, double limiter, int spacing, int mainSpacing) {
		//Recommended input 400, 100, 200, 180, 45, 90
		double rads = Math.PI * 2;
		while (rads >= 0) {
			double radians = 2 * Math.PI;
			double x = ((Math.cos(rads) * mainRadius) + centre);
			double y = ((Math.sin(rads) * mainRadius) + centre);
			while (radians >= Math.toRadians(limiter)) {
				switch(enemyType) {
				case("donut"):
					enemy = new Donut(currentLayer, level);
					break;
				case("ice"):
					enemy = new IceCream(currentLayer, level);
					break;
				case("txtbk"):
					enemy = new Textbook(currentLayer, level);
					break;
				case("clock"):
					enemy = new Clock(currentLayer, level);
					break;
				case("flask"):
					enemy = new Flask(currentLayer, level);
					break;
				case("melon"):
					enemy = new Watermelon(currentLayer, level);
					break;
				case("loan"):
					enemy = new StudentLoan(currentLayer, level);
					break;
				}
				enemy.setYpos((Math.sin(radians) * radius) + y);
				enemy.setXpos((Math.cos(radians) * radius) + x);
				enemies.add(enemy);
				radians -= Math.toRadians(spacing);
			}
			
			rads -= Math.toRadians(mainSpacing);
		}
	}
}
