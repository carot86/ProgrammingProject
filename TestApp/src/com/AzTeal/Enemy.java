package com.AzTeal;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.sprite.Sprite;

public class Enemy {
	
	private final int boundryLeft;
	private final int boundryRight;
	private final int boundryTop;
	private final int boundryBottom;	
	final PhysicsHandler physicsHandler;
	public Sprite enemy;
	private static final float VELOCITY = 100.0f;

	public Enemy(Sprite enemy, int left, int right, int top, int bottom){
		this.enemy = enemy;
		physicsHandler = new PhysicsHandler(enemy);
		enemy.registerUpdateHandler(physicsHandler);
		
		boundryLeft = left;
		boundryRight = right;
		boundryTop = top;
		boundryBottom = bottom;
	}
	
	public void move(float X, float Y){
		
		if(enemy.getX() < boundryLeft){
			this.physicsHandler.setVelocityX(VELOCITY);
		} else if(enemy.getY() > boundryRight){
			this.physicsHandler.setVelocityX(-VELOCITY);
		}

		if(enemy.getY() < boundryTop){
			this.physicsHandler.setVelocityY(VELOCITY);
		} else if(enemy.getY() > boundryBottom) {
			this.physicsHandler.setVelocityY(-VELOCITY);
		}
		move(X, Y);
	
	}   
}


