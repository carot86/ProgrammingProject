package com.AzTeal;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.sprite.Sprite;

public class Enemy implements Runnable{
	
	private final int boundryLeft;
	private final int boundryRight;
	private final int boundryTop;
	private final int boundryBottom;	
	final PhysicsHandler physicsHandler;
	public Sprite enemy;
	private float startX;
	private float startY;
	private static final float VELOCITY = 100.0f;

	public Enemy(Sprite enemy, float x, float y, int left, int right, int top, int bottom){
		this.enemy = enemy;
		physicsHandler = new PhysicsHandler(enemy);
		enemy.registerUpdateHandler(physicsHandler);
		
		startX = x;
		startY = y;
		
		this.physicsHandler.setVelocity(startX, startY);
		
		boundryLeft = left;
		boundryRight = right;
		boundryTop = top;
		boundryBottom = bottom;
	}
	
	public void move(){
		
		if(enemy.getX() < boundryLeft){
			this.physicsHandler.setVelocityX(VELOCITY);
		}else if(enemy.getX() > boundryRight){
			this.physicsHandler.setVelocityX(-VELOCITY);
		}

		if(enemy.getY() < boundryTop){
			this.physicsHandler.setVelocityY(VELOCITY);
		}else if(enemy.getY() > boundryBottom){
			this.physicsHandler.setVelocityY(-VELOCITY);
		}
	}   
	
	@Override
	public void run(){
		while(true){
			move();
			try{
				Thread.sleep(0);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}


