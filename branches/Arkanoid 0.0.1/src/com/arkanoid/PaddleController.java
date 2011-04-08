package com.arkanoid;

import java.util.Random;

/**
 * 
 @author matsgora
 * Handles the paddle logic
 */

public class PaddleController {

	/**
	 * Model
	 */
	private PaddleModel entityModel;
	
	/**
	 * 
	 @param Model model for this controller
	 */
	public PaddleController(PaddleModel Model) {
		super();
		this.setEntityModel(Model);
	}

	private PaddleModel getEntityModel() {
		return entityModel;
	}

	private void setEntityModel(PaddleModel entityModel) {
		this.entityModel = entityModel;
	}

	/**
	 * Handles the movement and updates the new position in the model.
	 @param dx change in x direction. 
	 */
	
	public void movementHandler(float dx){
		float newX = this.getEntityModel().getX()+dx;
		
		if (newX < 0){
			this.getEntityModel().setX(0);
		}else if (newX+this.getEntityModel().getSpriteSize() > this.getEntityModel().getArk().getCAMERA_WIDTH()){
			this.getEntityModel().setX(this.getEntityModel().getArk().getCAMERA_WIDTH()-this.getEntityModel().getSpriteSize());
		}else{
			this.getEntityModel().setX(newX);

		}	
	}

	/**
	 @see EntityView
	 */
	
	public float[] collides(EntityView view){
		float[] returnvalues = {1, 1};
		if (this.getEntityModel().getView().collidesWith(view)){
			if((entityModel.getArk().getBallView().getY() < (entityModel.getView().getY() + entityModel.getView().getHeight()))&&(entityModel.getArk().getBallView().getY()>(entityModel.getView().getY()+entityModel.getArk().getBallView().getHeight()))){
				returnvalues[0] = -1;
			}else{
			    Random randomGenerator = new Random();
			      float randomFloat = (float)-0.2*randomGenerator.nextFloat();
			    
			      returnvalues[1] = -1+randomFloat;
				
			}
			
		}
		return returnvalues;
	}
}

