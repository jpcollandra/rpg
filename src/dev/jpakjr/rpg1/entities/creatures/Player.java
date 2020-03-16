package dev.jpakjr.rpg1.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.jpakjr.rpg1.Game;
import dev.jpakjr.rpg1.Handler;
import dev.jpakjr.rpg1.entities.Entity;
import dev.jpakjr.rpg1.gfx.Animation;
import dev.jpakjr.rpg1.gfx.Assets;
import dev.jpakjr.rpg1.inventory.Inventory;

public class Player extends Creature {	

	private Animation animDown, animUp, animLeft, animRight, animDown1;
	
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	
	//Inventory
	private Inventory inventory;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = -2;
		bounds.y = -2;
		bounds.width = 32;
		bounds.height = 32;
		
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		
		animDown1 = new Animation(500, Assets.player_down1);
		
		inventory = new Inventory(handler);
		
		
	}

	public void tick() {
		//Animations
		animDown1.tick();
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//Attack
		checkAttacks();
		
		//Inventory
		inventory.tick();
		
	}
	
	private void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		if(inventory.isActive())
			return;
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 10;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2 - arSize/ 2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2 - arSize/ 2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().aLeft){
				ar.x = cb.x - arSize;
				ar.y = cb.y  + cb.height / 2 - arSize/ 2;
		}else if(handler.getKeyManager().aRight){
				ar.x = cb.x + cb.width;
				ar.y = cb.y  + cb.height / 2 - arSize/ 2;
		}else{
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				return;
			}
		}
		
	}
	
	public void die(){
		System.out.println("You suck");
	}
	
	private void getInput(){
		if(inventory.isActive())
			return;
		
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void postRender(Graphics g){
		inventory.render(g);
	}

	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else if(yMove > 0){
			return animDown.getCurrentFrame();
		}else{
			return animDown1.getCurrentFrame();
		}
	}
}
