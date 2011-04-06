package com.arkanoid;


public class PaddleController {

	private PaddleModel entityModel;
	
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

	public int[] collides(EntityView view){
		int[] returnvalues = {1, 1};
		if (this.getEntityModel().getView().collidesWith(view)){
			returnvalues[1] = -1;
		}
		return returnvalues;
	}
}

