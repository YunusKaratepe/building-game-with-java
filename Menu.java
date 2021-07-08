package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		if (mouseOver(mx, my,210, 150, 200, 64) == true && Game.gameState == STATE.Menu) {
			
			game.gameState = STATE.Select;	
		}
		else if(mouseOver(mx, my, 210, 250, 200, 64) == true && Game.gameState == STATE.Menu) {
			game.gameState = STATE.Help;
		}
		else if(mouseOver(mx, my, 210, 350, 200, 64 ) == true && Game.gameState == STATE.Menu ) {
			System.exit(1);
		}
		else if(mouseOver(mx, my, 210, 350, 200, 64) == true && Game.gameState == STATE.Help) {
			game.gameState = STATE.Menu;
		}
		else if(mouseOver(mx, my, 210, 350, 200, 64) == true && Game.gameState == STATE.End) {
			handler.clearAll(11);
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.BasicEnemy, handler));
			hud.setLevel(1);
			hud.setScore(0);
		}
		else if(mouseOver(mx, my, 210, 150, 200, 64) == true && game.gameState == STATE.Select) { // NORMAL
			handler.clearAll(handler.findObjectNumber());
			game.gameState = STATE.Game;
			handler.addObject(new Player (Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.BasicEnemy, handler));
		}
		else if(mouseOver(mx, my, 210, 250, 200, 64) == true && game.gameState == STATE.Select) { // HARD
			handler.clearAll(handler.findObjectNumber());
			game.gameState = STATE.Game;
			handler.addObject(new Player (Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.BasicEnemy, handler));
		}
		else if(mouseOver(mx, my, 210, 350, 200, 64) == true && Game.gameState == STATE.Select) {
			game.gameState = STATE.Menu;
		}
		
		
		
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
		
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 2, 40);
		Font fnt3 = new Font("arial", 1, 20);
		
		if(game.gameState == STATE.Menu) {
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu", 250, 75);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 267, 194);
		
		g.setColor(Color.white);
		g.drawRect(210, 250, 200, 64);
		g.drawString("Help", 267, 294);
		
		g.setColor(Color.white);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit", 267, 394);
		}
		else if(game.gameState == STATE.Help){
		
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 250, 75);
			
			
			g.setFont(fnt3);
			g.drawRect(116, 120, 400, 196);
			g.drawString("Up, down, left, right arrows to move.", 140, 160);
			g.drawString("Mouse for selecting menu objects.", 140, 190);
			g.drawString("Have fun!", 140, 220);
			g.drawString("Designed by Yunus Karatepe.", 140, 250);
			g.drawString("All rights reserved.", 140, 280);
			
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 267, 394);
		}
		if(game.gameState == STATE.Select) {
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("SELECT DIFFICULTY", 75, 75);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Normal", 244, 194);
			
			g.setColor(Color.white);
			g.drawRect(210, 250, 200, 64);
			g.drawString("Hard", 267, 294);
			
			g.setColor(Color.white);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 267, 394);
			}
		else if(game.gameState == STATE.End){
		
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 250, 75);
			
			g.setFont(fnt3);
			g.drawRect(116, 120, 400, 196);
			g.drawString("Your Score : " + hud.getScore(), 140, 160);
			g.drawString("Better Luck Next Time!", 140, 190);
			g.drawString("Have Fun!", 140, 220);
			g.drawString("Designed By Yunus Karatepe.", 140, 250);
			g.drawString("All Rights Reserved.", 140, 280);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Again!", 250, 394);
			
		}
		
		
		
	}
	
	
}
