package com.techonyourtime.main;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.material.Sign;

public class EventListener implements Listener {
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		Main.logger.info("sign placed");
        String line1 = e.getLine(0).toString();
        Main.logger.info(line1);
        	Main.logger.info("it ran");
        	e.getPlayer().sendMessage("You created a traffic light!");
        	Sign s = (Sign) e.getBlock().getState().getData();
        	Block b = e.getBlock();
        	Block attachedBlock = b.getRelative(s.getAttachedFace());
        	attachedBlock.setType(Material.STONE);
        	

	}

}
