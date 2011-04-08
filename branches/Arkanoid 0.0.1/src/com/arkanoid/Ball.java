package com.arkanoid;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Ball extends Sprite{
	private final PhysicsHandler mPhysicsHandler;
	private Arkanoid ark;
	

	public Ball(float pX, float pY, TextureRegion pTextureRegion, Arkanoid ark) {
		super(pX, pY, pTextureRegion);
		this.mPhysicsHandler = new PhysicsHandler(this);
		this.ark = ark;
		// TODO Auto-generated constructor stub
	}
	
	public float GetX(){
		return this.getX();
	}
	public float GetY(){
		return this.getY();
	}
	
	@Override
    protected void onManagedUpdate(final float pSecondsElapsed){
		if(this.mX < 0) {
			this.mPhysicsHandler.setVelocityX(ark.getVELOCITY());
			
		}else if(this.mX + this.getWidth() > ark.getCAMERA_WIDTH()) {
			this.mPhysicsHandler.setVelocityX(-ark.getVELOCITY());
		}
		if(this.mY < 0) {
				this.mPhysicsHandler.setVelocityY(ark.getVELOCITY());
		} else if(this.mY + this.getHeight() > ark.getCAMERA_HEIGHT()) {
			this.mPhysicsHandler.setVelocityY(-ark.getVELOCITY());
		}

            super.onManagedUpdate(pSecondsElapsed);
    }
}
