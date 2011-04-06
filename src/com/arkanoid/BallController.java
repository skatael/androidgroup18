package com.arkanoid;

import org.anddev.andengine.entity.sprite.Sprite;

import android.util.Log;


public class BallController {

	private BallModel entityModel;
	
	public BallController(BallModel entityModel) {
		this.setEntityModel(entityModel);
		this.getEntityModel().getmPhysicsHandler().setVelocity(-this.getEntityModel().getVelocity(), this.getEntityModel().getVelocity());
	}
	
	private BallModel getEntityModel() {
		return entityModel;
	}
	private void setEntityModel(BallModel entityModel) {
		this.entityModel = entityModel;
	}

	public void update(){
		
		if (this.getEntityModel().getEntityView().getY() > this.getEntityModel().getTouchArea()){
			
			//Log.i("Arkanoid: ballController", String.valueOf(this.getEntityModel().getEntityView().getY()));
			//Log.i("Arkanoid: valueY", String.valueOf(this.getEntityModel().getTouchArea()));
			this.getEntityModel().getArk().die();
			this.getEntityModel().getEntityView().setPosition(this.getEntityModel().getX(), this.getEntityModel().getY());
			return;
		}
	
		if (this.getEntityModel().getEntityView().getX() < 0) {
            this.getEntityModel().getmPhysicsHandler().setVelocityX(this.getEntityModel().getVelocity());
            return;
		} else if(this.getEntityModel().getEntityView().getX() + this.getEntityModel().getEntityView().getWidth() > this.getEntityModel().getArk().getCAMERA_WIDTH()) {
            this.getEntityModel().getmPhysicsHandler().setVelocityX(-this.getEntityModel().getVelocity());
            return;
		}

		if(this.getEntityModel().getEntityView().getY() < 0) {
            this.getEntityModel().getmPhysicsHandler().setVelocityY(this.getEntityModel().getVelocity());
            return;
		} else if(this.getEntityModel().getEntityView().getY() + this.getEntityModel().getEntityView().getHeight() > this.getEntityModel().getArk().getCAMERA_HEIGHT()) {
			this.getEntityModel().getmPhysicsHandler().setVelocityY(-this.getEntityModel().getVelocity());
			return;
		}
		
		for (EntityView entity: this.getEntityModel().getEntityListeners()){
			int[] values = entity.collides(this.getEntityModel().getEntityView());
			this.getEntityModel().getmPhysicsHandler().setVelocityX(values[0]*this.getEntityModel().getmPhysicsHandler().getVelocityX());
			this.getEntityModel().getmPhysicsHandler().setVelocityY(values[1]*this.getEntityModel().getmPhysicsHandler().getVelocityY());
			
		}
	}

}
