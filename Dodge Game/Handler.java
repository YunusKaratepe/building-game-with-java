package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	private int anaObject = 0;
	
	public void tick() {
		for(int i = 0;i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		
	}
	public void render(Graphics g) {
		for(int i = 0;i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	public void clearEnemies() {
		for(int i = 0;i < object.size(); i++) {	
			GameObject tempObject = object.get(i);
			if(tempObject.getId() == ID.Player) {
				
				object.clear();
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
			}
		}
	}
	public int findObjectNumber() {
		int sayac = 0; 
		for(int i = 0; i < object.size();i++) {
			GameObject tempObject = object.get(i);
			if(tempObject.getId() != ID.Trail) sayac++;
		}return sayac;
	}
	public void clearAll(int size) {
				for(int i = 0; i < size; i++) this.object.remove();
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	

	

}
