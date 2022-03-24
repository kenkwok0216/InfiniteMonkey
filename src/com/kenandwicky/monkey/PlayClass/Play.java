package com.kenandwicky.monkey.PlayClass;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.kenandwicky.monkey.InfiniteMonkey;

import me.kenandwicky.candycrush.CandyCrush;
import me.kenandwicky.candycrush.Board.Matching;
import me.kenandwicky.candycrush.Board.Move;
import me.kenandwicky.candycrush.GameLoop.Game;

public class Play implements CommandExecutor {
	
	public static int gameLoopID = -1; //gameLoopId return -1 when failed
	public static Loop loop;
	

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (gameLoopID != -1) {
			Bukkit.getScheduler().cancelTask(gameLoopID);
		}
		
		loop = new Loop();
		//CandyCrush.isStart = true;
		CandyCrush.game = new Game(CandyCrush.boardclass);
		gameLoopID = Bukkit.getScheduler().scheduleSyncRepeatingTask(InfiniteMonkey.plugin,
							loop,
							20, 100);	//Measure in takes (20 takes in second)
							// first number is delay 
							//e.g. 60 means "wait for 60 takes before it start"
							//the second number is interval
							//e.g. 20 means for every 20 takes. it will run "loop"
		return true;
	}
	
	
	
	
}
