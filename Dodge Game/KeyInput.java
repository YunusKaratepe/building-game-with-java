package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	Random r = new Random();
	private HUD hud;
	
	public KeyInput(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		keyDown[0]=false; // UP
		keyDown[1]=false; // DOWN
		keyDown[2]=false; // RIGHT
		keyDown[3]=false; // LEFT
	}
	
	 
	
	                             
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0;i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_UP)    { tempObject.setVelY(-5); keyDown[0]=true; }
				if(key == KeyEvent.VK_DOWN)  { tempObject.setVelY(+5); keyDown[1]=true; }
				if(key == KeyEvent.VK_RIGHT) { tempObject.setVelX(+5); keyDown[2]=true; }
				if(key == KeyEvent.VK_LEFT)  { tempObject.setVelX(-5); keyDown[3]=true; }
			}
		}
		if (key == KeyEvent.VK_ENTER) {
			
			if(Game.gameState == STATE.Game) {
				
				if(Game.paused) Game.paused = false;
				else Game.paused = true;
			}
		
			
		}
		if(key == KeyEvent.VK_ESCAPE) {
			Game.gameState = STATE.Menu;
			handler.clearAll(handler.findObjectNumber());
			HUD.HEALTH = 100;
			hud.setLevel(1);
			hud.setScore(0);
			for(int i = 0; i < 10; i++) handler.addObject(new MenuParticle (r.nextInt(640), r.nextInt(640/ 12 * 9), ID.MenuParticle, handler));
		}
		
		
	}
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
for(int i = 0;i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_UP) 	 keyDown[0]=false;//tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN)  keyDown[1]=false;//tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) keyDown[2]=false;//tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT)  keyDown[3]=false;//tempObject.setVelX(0);
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				else if(keyDown[0] && !keyDown[1]) tempObject.setVelY(-5);
				else if(!keyDown[0] && keyDown[1]) tempObject.setVelY(5);
				
				//horizontal movement
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
				else if(keyDown[2] && !keyDown[3]) tempObject.setVelX(5);
				else if(!keyDown[2] && keyDown[3]) tempObject.setVelX(-5);
			}
			
		}
		
	}
	
}
