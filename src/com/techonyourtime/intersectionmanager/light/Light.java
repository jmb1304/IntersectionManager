package com.techonyourtime.intersectionmanager.light;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Light {
	private static Location lightLocation = new Location(null, 0, 0, 0);
	private static int lightState;
	public Light(Location location){
		lightLocation = location;
	}
	
	public static void setLightState(int state){
		lightState = state;
	}
	public static int getLightState(){
		return lightState;
	}
}
