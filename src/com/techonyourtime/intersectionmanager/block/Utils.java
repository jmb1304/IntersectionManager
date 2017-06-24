package com.techonyourtime.intersectionmanager.block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Utils {
	public static void SetBlock(Location location, Material material){
		Block block = location.getBlock();
		block.setType(material);
	}
	public static void SetBlock(Location location, Material material, int dataValue){
		Block block = location.getBlock();
		block.setType(material);
		block.setData((byte) dataValue);
	}

}
