package com.arkanoid;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Block extends EntityView{
	
	private int lives;
	private int worth;
	private String powerup;
	private Arkanoid ark;
	private boolean destroy;
	
	//temp constructor
	public Block(float pX, float pY, TextureRegion pTextureRegion, Arkanoid ark) {
		super(pX, pY, pTextureRegion);
		this.ark = ark;
		// TODO Auto-generated constructor stub
		destroy = false;
		worth = 678;
		
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
		this.destroy = true;
		ark.getBlockController().removeBlock();
		ark.updateScore(this.worth);
		
	}

	@Override
	public int[] collides(EntityView view) {
		int[] returnvalues = {1, 1};
		if(this.collidesWith(view)&& !destroy){
			if((ark.getBallView().getY() < (this.getY() + this.getHeight()))&&(ark.getBallView().getY()>(this.getY()+ark.getBallView().getHeight()))){
				returnvalues[0] = -1;
			}else{
				returnvalues[1] = -1;
				
			}
			
			
			gotHit();
			
			
		}
		return returnvalues;
	}
	
	public boolean getDestroy(){
		return destroy;
	}

}
