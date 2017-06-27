package com.techonyourtime.intersectionmanager.light;

import java.util.ArrayList;

public class Lights {
	private static ArrayList<Light> lights = new ArrayList<Light>();
	
	//Returns an int so we can know what light ID it is.
	public static int addLight(Light light){
		lights.add(light);
		return lights.indexOf(light);
	}
	
	public static Light getLight(int id){
		return lights.get(id);
	}

}
