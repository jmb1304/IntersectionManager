package com.techonyourtime.main;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	@Override
	public void onEnable() {
		
		logger.info("Intersection Manager v0.1 Has Been Enabled.");
	}
	@Override
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("intersection")){
			player.sendMessage("It Worked!");
	}
	return true;
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
	    if (e.getPlayer().hasPermission("sign.color")) {
	        String line1 = e.getLine(1);
	        if (line1.equalsIgnoreCase("[tlight]")){
	        	e.getPlayer().sendMessage("You created a traffic light!");
	        }
	    }
	}
	 
}