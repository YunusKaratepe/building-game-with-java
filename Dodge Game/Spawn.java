package com.tutorial.main;

import java.util.Random;

public class Spawn{
	
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	
	public Spawn(Handler handler, HUD hud){
		
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		
		scoreKeep++;
		
		if(scoreKeep == 100) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);
			
			if(hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.BasicEnemy, handler));
			}
			else if(hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.BasicEnemy, handler));
			}
			else if(hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.FastEnemy, handler));
			}
			else if(hud.getLevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.SmartEnemy, handler));
			}
			else if(hud.getLevel() == 7) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.BasicEnemy, handler));
			}
			else if(hud.getLevel() == 8) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.FastEnemy, handler));
			}
			else if(hud.getLevel() == 12) {
			handler.clearEnemies();
			handler.addObject(new EnemyBoss(((Game.WIDTH / 2) -48), -120, ID.EnemyBoss, handler));
			}
		}

	}
}