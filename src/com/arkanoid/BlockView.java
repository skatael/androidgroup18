package com.arkanoid;

public class BlockView extends EntityView {
	
	private Arkanoid ark;
	
	public BlockView(float pX, float pY,Arkanoid ark){
		super(pX, pY, null);
		this.ark = ark;
	}

	@Override
	public float[] collides(EntityView view) {
		// TODO Auto-generated method stub
		return null;
	}

}
