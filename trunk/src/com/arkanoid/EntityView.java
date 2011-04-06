package com.arkanoid;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public abstract class EntityView extends Sprite {

	public EntityView(float pX, float pY, TextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
		// TODO Auto-generated constructor stub
	}
	
	//returns velocity direction for ball [x dir, y dir]
	public abstract int[] collides(EntityView view);
}
