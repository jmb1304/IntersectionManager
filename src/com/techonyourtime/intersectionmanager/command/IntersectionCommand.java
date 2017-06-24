package com.techonyourtime.intersectionmanager.command;

public class IntersectionCommand {
	private static boolean EnableEditMode = false;
	public static void createIntersection(){
		
	}
	public static void setEditModeState(Boolean state){
		EnableEditMode = state;
	}
	public static boolean getEditModeState(){
		return EnableEditMode;
	}

}
