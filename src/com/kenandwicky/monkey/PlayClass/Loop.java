package com.kenandwicky.monkey.PlayClass;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import me.kenandwicky.candycrush.CandyCrush;
import me.kenandwicky.candycrush.Board.Board;
import me.kenandwicky.candycrush.Board.Matching;
import me.kenandwicky.candycrush.Board.Move;
import me.kenandwicky.candycrush.GameLoop.Game;

public class Loop implements Runnable {
	
	private static int x = 0, y = 0;
	private static double xDiff = 0, yDiff = 0, zDiff = 0;
	private static Random rnd = new Random();
	private static int n = 0;

	@Override
	public void run() {
		n++;
		int random_direction = rnd.nextInt(3); //Control xDiff (0) or yDiff (2) or zDiff (1)
		int random_positive = rnd.nextInt(2); //0 negative Diff, 1 positive Diff
		xDiff = 0; yDiff = 0; zDiff = 0;
		
		if(n > 9999) {
			Bukkit.getScheduler().cancelTask(Play.gameLoopID);
		}
		
		if(random_direction == 0) {
			if(random_positive == 0) {
				xDiff = -0.5;
			} else if(random_positive == 1) {
				xDiff = 0.5;
			}
		} else if (random_direction == 1){
			if(random_positive == 0) {
				zDiff = -0.5;
			} else if(random_positive == 1) {
				zDiff = 0.5;
			}
		} else if (random_direction == 2) {
				yDiff = 0.5;
		}
		
		
	
		if(xDiff != 0) {
			if(xDiff > 0) {
				Board.player.chat(n + ":A (Left)");
				//From Candy Crush Code
				if(x == -1 && y == 0 && Move.selected == true) {
					return;
				} else if (x > -1 && y == 0 && Move.selected == true) {
					Game.swapLeft();
					Game.moveLeft();
					if(Matching.checkremove() == false) {
						Game.swapRight();
						Move.selected = false;
						Game.UnSelect();
						x = x - 1;
					} else {
    					Move.selected = false;
    					Game.UnSelect();
    					Matching.remove();
    					x = x - 1;
					}
				
				} else if(Move.selected == false) {
					Game.moveLeft();
				}
				//up to this point
			} else if (xDiff < 0) {
				Board.player.chat(n + ":D (Right)");
				//From Candy Crush Code
				if(x == 1 && y == 0 && Move.selected == true) {
					return;
				} else if (x < 1 && y == 0 && Move.selected == true) {
				
					Game.swapRight();
					Game.moveRight();
					if(Matching.checkremove() == false) {
						Game.swapLeft();
						Move.selected = false;
						Game.UnSelect();
						x = x + 1;
					} else {
    					Move.selected = false;
    					Game.UnSelect();
    					Matching.remove();
    					x = x + 1;
					}
				} else if(Move.selected == false) { 
					Game.moveRight();
				}
				//up to this point
			}
		} else if (zDiff != 0) {
			if(zDiff > 0) {
				Board.player.chat(n + ":W (Forward)");
				//From Candy Crush Code
				if(y == -1 && x == 0 && Move.selected == true) {
					return;
				}else if (y > -1 && x == 0 && Move.selected == true){
					Game.swapUp();
					Game.moveUp();
					if(Matching.checkremove() == false) {
						Game.swapDown();
						Move.selected = false;
						Game.UnSelect();
						y = y - 1;
					} else {
    					Move.selected = false;
    					Game.UnSelect();
    					Matching.remove();
    					y = y - 1;
					}
				
				} else if (Move.selected == false) {
					Game.moveUp();
				}
				//up to this point
			} else if(zDiff < 0) {
				Board.player.chat(n + ":S (Backward)");
				//From Candy Crush Code
				if(y == 1 && x == 0 && Move.selected == true ) {
					return;
				} else if (y < 1 && x == 0 && Move.selected == true){
					Game.swapDown();
					Game.moveDown();
					if(Matching.checkremove() == false) {
						Game.swapUp();
						Move.selected = false;
						Game.UnSelect();
						y = y + 1;
					} else {
    					Move.selected = false;
    					Game.UnSelect();
    					Matching.remove();
    					y = y + 1;
					}
				
				} else if (Move.selected == false) {
					Game.moveDown();
				}
				//up to this point
			}
		} else if (yDiff != 0) {
			Board.player.chat(n + ":Space (Jump)");
			if(CandyCrush.isfall == false) {
				//From Candy Crush Code
				if(Move.selected == false) {
					Game.Select();
					Move.selected = true;
					x = 0;
					y = 0;
				} else {
					Game.UnSelect();
					Move.selected = false;
					x = 0;
					y = 0;
				}
				//up to this point
			}		
		}			
	}
	

}
