package com.arkanoid;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

import com.arkanoid.Block;

public class UnCrushableBlock extends Block{
	private int lives;
	private int worth;
	private String powerup;
	
	public UnCrushableBlock(float pX, float pY, TextureRegion pTextureRegion, Arkanoid ark) {
		super(pX, pY, pTextureRegion, ark);
		// TODO Auto-generated constructor stub
	}
	public float GetX(){
		return this.getX();
	}
	public float GetY(){
		return this.getY();
	}
	public void gotHit(){
		if(lives <= 0){
			//display explosion el no s�nn
			
			//create powerup?
		}
	}

}
