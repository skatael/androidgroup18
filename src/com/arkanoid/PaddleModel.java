package com.arkanoid;

public class PaddleModel {

	private float x,y,touchArea;
	private Arkanoid ark;
	private float spriteSize;
	private EntityView view;
	
	public PaddleModel(float x, float y, float touchArea, Arkanoid ark, float spriteSize, EntityView view) {
		this.setX(x);
		this.setY(y);
		this.setTouchArea(touchArea);
		this.setArk(ark);
		this.setSpriteSize(spriteSize);
		this.setView(view);
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

	private void setY(float y) {
		this.y = y;
	}

	public float getTouchArea() {
		return touchArea;
	}

	private void setTouchArea(float touchArea) {
		this.touchArea = touchArea;
	}

	public Arkanoid getArk() {
		return ark;
	}

	private void setArk(Arkanoid ark) {
		this.ark = ark;
	}

	public float getSpriteSize() {
		return spriteSize;
	}

	private void setSpriteSize(float spriteSize) {
		this.spriteSize = spriteSize;
	}

	public EntityView getView() {
		return view;
	}

	private void setView(EntityView view) {
		this.view = view;
	}
	
	
	
}
