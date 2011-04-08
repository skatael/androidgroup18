package com.arkanoid;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

import com.arkanoid.Block;

/**
 * Class used to create blocks that are destroyable
 */
public class CrushableBlock extends Block{
	/**
	 * how many hits a block can take
	 */
	private int lives;
	/**
	 *how many points a block is worth when destroyed
	 */
	private int worth;
	/**
	 * which powerup the block contains
	 */
	private String powerup;
	
	/**
	 * constructor
	 * @param pX x-coordinate of the block
	 * @param pY y-coordinate of the block
	 * @param pTextureRegion textureregion of the block
	 * @param ark pointer to the main class
	 */
	public CrushableBlock(float pX, float pY, TextureRegion pTextureRegion, Arkanoid ark) {
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
		lives =lives -1;
		if(lives <= 0){
			
		}
	}


}
