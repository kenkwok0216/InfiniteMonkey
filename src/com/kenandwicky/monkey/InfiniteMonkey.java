package com.kenandwicky.monkey;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.kenandwicky.monkey.PlayClass.Play;

import me.kenandwicky.candycrush.CandyCrush;
import me.kenandwicky.candycrush.GameLoop.Game;

public class InfiniteMonkey extends JavaPlugin implements Listener {
	private CandyCrush api2 = (CandyCrush) Bukkit.getServer().getPluginManager().getPlugin("SingleCandyCrush");
	public static Plugin plugin;
	
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage("Monkey is respawning");
		plugin = this;
		this.getCommand("autogame").setExecutor(new Play());
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

			

		return true;
	}
	
	
}