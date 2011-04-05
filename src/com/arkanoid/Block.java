package com.arkanoid;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Block extends Sprite{
	
	private int lives;
	private int worth;
	private String powerup;
	
	//temp constructor
	public Block(float pX, float pY, TextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
		
		// TODO Auto-generated constructor stub
	}
	
	//final constructor
//	public Block(float pX, float pY, TextureRegion pTextureRegion, int lives, int worth, String powerup) {
//		super(pX, pY, pTextureRegion);
//		this.lives = lives;
//		this.worth = worth;
//		this.powerup = powerup;
//		// TODO Auto-generated constructor stub
//	}
	
	public float GetX(){
		return this.getX();
	}
	public float GetY(){
		return this.getY();
	}
	public void gotHit(){
		lives =lives -1;
		if(lives <= 0){
			//display explosion el no sånn
			
			//create powerup?
		}
	}

}
