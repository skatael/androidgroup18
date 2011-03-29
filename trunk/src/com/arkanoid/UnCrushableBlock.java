package com.arkanoid;

import org.anddev.andengine.opengl.texture.region.TextureRegion;

import com.arkanoid.Block;

public class UnCrushableBlock extends Block{

	public UnCrushableBlock(float pX, float pY, TextureRegion pTextureRegion) {
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
