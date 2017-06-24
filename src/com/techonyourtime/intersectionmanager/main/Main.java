package com.techonyourtime.intersectionmanager.main;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.material.Sign;
import org.bukkit.plugin.java.JavaPlugin;

import com.techonyourtime.intersectionmanager.command.IntersectionCommand;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	public final static Logger logger = Logger.getLogger("Minecraft");
	@Override
	public void onEnable() {
		
		logger.info("Intersection Manager v0.1 Has Been Enabled.");
		getServer().getPluginManager().registerEvents(new EventListener(), this);
	}
	@Override
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("intersection")){
			logger.info(args[0]);
			logger.info(Boolean.toString(IntersectionCommand.getEditModeState()));
			if(args[0].equalsIgnoreCase("create") & !IntersectionCommand.getEditModeState()){
				player.sendMessage(ChatColor.GREEN + "Intersection Edit Mode Activated");
				IntersectionCommand.setEditModeState(true);
			}
			else if(args[0].equalsIgnoreCase("create") & IntersectionCommand.getEditModeState()){
				player.sendMessage(ChatColor.RED + "Intersection Edit Mode Deactivated");
				IntersectionCommand.setEditModeState(false);
			}
	}
	return true;
	}
	
	
	 
}