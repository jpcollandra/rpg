package dev.jpakjr.rpg1.entities.statics;

import dev.jpakjr.rpg1.Handler;
import dev.jpakjr.rpg1.entities.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
		
	}

}
