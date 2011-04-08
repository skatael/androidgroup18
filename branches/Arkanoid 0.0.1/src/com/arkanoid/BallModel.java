package com.arkanoid;

import java.util.ArrayList;
import java.util.List;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.Sprite;


/**
 * 
 @author matsgora
 *
 *The model contains the state of the entity. In this case the ball
 */

public class BallModel {
	
	private Arkanoid ark;
	private float x,y;
	private EntityView view;
	private float velocity;
	private PhysicsHandler mPhysicsHandler;
	private List<EntityView> entityListeners;
	private int touchArea;
	
	
	/**
	 * 
	 @param ark parent game reference
	 @param x initial x position when entity is placed under game initializing (possible remove)
	 @param y initial y position when entity is placed under game initializing (possible remove)
	 @param mPhysicsHandler the physicshandler for this entity
	 @param view the view of this model
	 @param touchArea ?
	 */
	public BallModel(Arkanoid ark, float x, float y, PhysicsHandler mPhysicsHandler, EntityView view, int touchArea) {
		this.setArk(ark);
		this.setX(x);
		this.setY(y);
		this.setMPhysicsHandler(mPhysicsHandler);
		this.setVelocity(ark.getVELOCITY());
		this.setEntityView(view);
		this.entityListeners = new ArrayList<EntityView>();
		this.setTouchArea(touchArea);
	}
	
	public Arkanoid getArk() {
		return ark;
	}
	private void setArk(Arkanoid ark) {
		this.ark = ark;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public EntityView getEntityView() {
		return view;
	}

	private void setEntityView(EntityView entity) {
		this.view = entity;
	}

	public float getVelocity() {
		return velocity;
	}
	private void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public PhysicsHandler getmPhysicsHandler() {
		return mPhysicsHandler;
	}
	
	public void setMPhysicsHandler(PhysicsHandler mPhysicsHandler){
		this.mPhysicsHandler = mPhysicsHandler;
	}

	public List<EntityView> getEntityListeners() {
		return entityListeners;
	}

	/**
	 * Add entities that should be checked for collisions with this entity.
	 @param Listener entity that should be checked on update
	 @see BallView.onManagedUpdate() and BallController.update() for how collisions are handled
	 */
	public void addListeners(EntityView Listener) {
		this.entityListeners.add(Listener);
	}
	
	/**
	 * Remove entities that no longer should be checked for collisions with this entity.
	 @param Listener entity that should be removed
	 */
	public void delListener(Sprite Listener) {
		this.entityListeners.remove(Listener);
	}

	public int getTouchArea() {
		return touchArea;
	}

	private void setTouchArea(int touchArea) {
		this.touchArea = touchArea;
	}
	
	
	
}
