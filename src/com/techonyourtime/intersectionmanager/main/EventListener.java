package com.techonyourtime.intersectionmanager.main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
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
}
