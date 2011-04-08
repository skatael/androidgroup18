package com.arkanoid;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

import com.arkanoid.Block;
/**
 * class used for creating undestroyable blocks
 * @author dahl
 *
 */
public class UnCrushableBlock extends Block{
	private int lives;
	private int worth;
	private String powerup;
	
	/**
	 * constructor
	 * @param pX x-coordinate of the block
	 * @param pY y-coordinate of the block
	 * @param pTextureRegion textureregion of the block
	 * @param ark pointer to the main class
	 */
	public UnCrushableBlock(float pX, float pY, TextureRegion pTextureRegion, Arkanoid ark) {
		super(pX, pY, pTextureRegion, ark);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return x-coordinate
	 */
	public float GetX(){
		return this.getX();
	}
	/**
	 * @return y-coordinate
	 */
	public float GetY(){
		return this.getY();
	}
	/**
	 * method called when the block is hit
	 */
	public void gotHit(){
		
			
	}
}



