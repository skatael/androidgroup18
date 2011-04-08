package com.arkanoid;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;


/**
 * 
 @author matsgora
 *
 *Abstract view that generates an EntityView. This extends the Sprite class and 
 *forces the entity to implement the collides method
 *
 */
public abstract class EntityView extends Sprite {

	public EntityView(float pX, float pY, TextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Used to check for collission with this object. Returns an array that 
	 * inicate the new direction the colliding object should take 
	  @param view EntityView that is checked for collision with this entity
	  @return array which inidcates the new direction the ball should take [xdir, ydir]
	 */
	public abstract float[] collides(EntityView view);
}
