package com.arkanoid;

import org.anddev.andengine.opengl.texture.region.TextureRegion;
/**
 * 
 * @author Dahl
 * The class used in creating blocks for the game
 */
public class Block extends EntityView{
	/**
	 * how many more hits the block can take before it's destroyed
	 */
	private int lives;
	/**
	 * how many points the block is worth when destroyed
	 */
	private int worth;
	/**
	 * which powerup the block contains assuming it contains one
	 */
	private String powerup;
	/**
	 * pointer to the main class
	 */
	private Arkanoid ark;
	/**
	 * shows whether the block is destroyed or not
	 */
	private boolean destroy;
	
	/**
	 * Constructor for blocks
	 * @param pX position of the block along the x-axis
	 * @param pY position of the block along the y-axis
	 * @param pTextureRegion the textureregion to add the block-sprite to
	 * @param ark pointer to the main class of the game
	 */
	public Block(float pX, float pY, TextureRegion pTextureRegion, Arkanoid ark) {
		super(pX, pY, pTextureRegion);
		this.ark = ark;
		destroy = false;
		worth = 678;
		
	}
	
	/**
	 * @return the x-coordinate of the block
	 */
	public float GetX(){
		return this.getX();
	}
	/**
	 * 
	 * @return the y-coordinate of the block
	 */
	public float GetY(){
		return this.getY();
	}
	
	/**
	 * Method that is called when the block is hit
	 * Destroys the block and updates the score
	 */
	public void gotHit(){
		this.destroy = true;
		ark.getBlockController().removeBlock();
		ark.updateScore(this.worth);
		
	}
	
	/**
	 * method that changes the ball's speed according to what it hit and how it hit something
	 * @return values used to change the speed of the ball according to how the collision happens
	 */
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
	
	/**
	 * Retuns the value of the boolean destroy
	 * @return whether the block is destroyed or not
	 */
	public boolean getDestroy(){
		return destroy;
	}

}
