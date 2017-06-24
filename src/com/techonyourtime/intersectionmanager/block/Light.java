package com.techonyourtime.intersectionmanager.block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Light {
	private static Location lightLocation = new Location(null, 0, 0, 0);
	public Light(Location location){
		lightLocation = location;
	}
	
	public static void setLight(int state){
		if(state == LightState.GreenLight){
			Utils.SetBlock(lightLocation, Material.STAINED_CLAY, 5);
			
		}
		if(state == LightState.YellowLight){
			
		}
		if(state == LightState.RedLight){
	
		}
	}
}
