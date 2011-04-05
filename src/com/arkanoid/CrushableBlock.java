package com.arkanoid;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

import com.arkanoid.Block;


public class CrushableBlock extends Block{
	private int lives;
	private int worth;
	private String powerup;
	
	public CrushableBlock(float pX, float pY, TextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
		// TODO Auto-generated constructor stub
	}
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
