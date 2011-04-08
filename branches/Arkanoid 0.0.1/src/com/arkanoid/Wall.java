package com.arkanoid;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Wall extends Sprite{

	public Wall(float pX, float pY, TextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
		// TODO Auto-generated constructor stub
	}
	public float GetX(){
		return this.getX();
	}
	public float GetY(){
		return this.getY();
	}
}
