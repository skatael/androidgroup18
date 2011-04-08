package com.arkanoid;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

/**
 * 
 @author matsgora
 *Returns the View of the ball. 
 */

public class BallView extends EntityView {
	
	/**
	 * Model
	 */
	private BallModel entityModel;
	/**
	 * Controller
	 */
	private BallController entityController;
	
	
	/**
	 * Instantiate the BallView, BallModel and BallController
	 * 
	 @param pX X placement in screen
	 @param pY Y placement in screen
	 @param pTextureRegion
	 @param ark Refer to parent game
	 @param touchArea ?
	 */
	public BallView(float pX, float pY, TextureRegion pTextureRegion, Arkanoid ark, int touchArea) {
		super(pX, pY, pTextureRegion);
		
		this.setEntityModel(new BallModel(ark, pX, pY, new PhysicsHandler(this), this, touchArea));
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
	
	/**
	 * 
	 @see BallModel
	 */
	public void addListener(EntityView Listener){
		this.getEntityModel().addListeners(Listener);
	}
	
	/**
	 * 
	 @see BallModel
	 */
	public void delListener(EntityView Listener){
		this.getEntityModel().delListener(Listener);
	}
	
	
	/**
	 * Method called by andengine on new tick. Ball physics handed over to the controller.
	 @see PaddleController PaddleController.update()
	 */
	@Override
    protected void onManagedUpdate(final float pSecondsElapsed) { 
        super.onManagedUpdate(pSecondsElapsed);
		this.getEntityController().update();
    }

	/**
	 * This method is not used here
	 @see EntityView
	 */
	@Override
	public float[] collides(EntityView view) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
