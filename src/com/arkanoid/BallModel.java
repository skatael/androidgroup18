package com.arkanoid;

import java.util.ArrayList;
import java.util.List;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.Sprite;


public class BallModel {
	
	private Arkanoid ark;
	private float x,y;
	private EntityView entity;
	private float velocity;
	private PhysicsHandler mPhysicsHandler;
	private List<EntityView> entityListeners;
	
	public BallModel(Arkanoid ark, float x, float y, PhysicsHandler mPhysicsHandler, EntityView entity) {
		this.setArk(ark);
		this.setX(x);
		this.setY(y);
		this.setMPhysicsHandler(mPhysicsHandler);
		this.setVelocity(ark.getVELOCITY());
		this.setEntityView(entity);
		this.entityListeners = new ArrayList<EntityView>();
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
		return entity;
	}

	private void setEntityView(EntityView entity) {
		this.entity = entity;
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

	public void addListeners(EntityView Listener) {
		this.entityListeners.add(Listener);
	}
	
	public void delListener(Sprite Listener) {
		this.entityListeners.remove(Listener);
	}
	
	
	
}
