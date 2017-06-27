package com.techonyourtime.intersectionmanager.main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Sign;

public class EventListener implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		// bunch of junk will be replaced eventually
		//gets first line of sign
		Main.logger.info("sign placed");
        String line1 = e.getLine(0).toString();
        //makes sure the sign was associated with the plugin
        if(line1.equalsIgnoreCase("[int]")){
        	e.getPlayer().sendMessage("You created a traffic light!");
        	//gets the block and calculates the block it is attached to
        	Sign s = (Sign) e.getBlock().getState().getData();
        	Block b = e.getBlock();
        	Block attachedBlock = b.getRelative(s.getAttachedFace());
        	//Sets the block type to a different one so they know it worked
        	attachedBlock.setType(Material.STAINED_CLAY);
        	attachedBlock.setData((byte) 5);
        	//Gets block info and creates a new location to create a new light
        	int x = attachedBlock.getX();
        	int y = attachedBlock.getY();
        	int z = attachedBlock.getZ();
        	World world = attachedBlock.getWorld();
        	Location location = new Location(world, x, y, z);
        }
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if (e.getClickedBlock().getType() == Material.SIGN){
				org.bukkit.block.Sign sign = (org.bukkit.block.Sign) e.getClickedBlock().getState();
				if (sign.getLine(0) == "[int]"){
					e.getPlayer().sendMessage("You Clicked an Intersection Sign!");
					sign.setLine(1, ChatColor.GREEN + "Traffic Light!");
					
				}
				
			}
		}
		else return;
		
	}
}
