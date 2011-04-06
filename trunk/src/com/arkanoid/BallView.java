package com.arkanoid;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class BallView extends EntityView {
	
	private BallModel entityModel;
	private BallController entityController;
	
	public BallView(float pX, float pY, TextureRegion pTextureRegion, Arkanoid ark) {
		super(pX, pY, pTextureRegion);
		
		this.setEntityModel(new BallModel(ark, pX, pY, new PhysicsHandler(this), this));
		this.setEntityController(new BallController(this.getEntityModel()));
		
		this.registerUpdateHandler(this.getEntityModel().getmPhysicsHandler());
	}

	private BallModel getEntityModel() {
		return entityModel;
	}

	private void setEntityModel(BallModel entityModel) {
		this.entityModel = entityModel;
	}

	private BallController getEntityController() {
		return entityController;
	}

	private void setEntityController(BallController entityController) {
		this.entityController = entityController;
	}
	
	public void addListener(EntityView Listener){
		this.getEntityModel().addListeners(Listener);
	}
	
	public void delListener(EntityView Listener){
		this.getEntityModel().delListener(Listener);
	}
	
	@Override
    protected void onManagedUpdate(final float pSecondsElapsed) { 
			this.getEntityController().update();
            super.onManagedUpdate(pSecondsElapsed);
    }

	@Override
	public int[] collides(EntityView view) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
