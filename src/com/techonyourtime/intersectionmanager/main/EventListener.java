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
		Main.logger.info("sign placed");
        String line1 = e.getLine(0).toString();
        if(line1.equalsIgnoreCase("[int]")){
        	e.getPlayer().sendMessage("You created a traffic light!");
        	Sign s = (Sign) e.getBlock().getState().getData();
        	Block b = e.getBlock();
        	Block attachedBlock = b.getRelative(s.getAttachedFace());
        	attachedBlock.setType(Material.STAINED_CLAY);
        	attachedBlock.setData((byte) 5);
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
			if (e.getClickedBlock().getState() instanceof Sign){
				org.bukkit.block.Sign sign = (org.bukkit.block.Sign) e.getClickedBlock().getState();
				if (sign.getLine(0) == "[int]"){
					e.getPlayer().sendMessage("You Clicked an Intersection Sign!");
					sign.setLine(1, ChatColor.GREEN + "Traffic Light");
					
				}
				
			}
		}
		else return;
		
	}
}
