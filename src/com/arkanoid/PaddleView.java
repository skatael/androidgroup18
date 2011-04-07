package com.arkanoid;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import android.util.Log;
import android.view.MotionEvent;

/**
 * 
 @author matsgora
 * Returns the View of the paddle. Implements IOnSceneTouchListener. Must register touchlistener (scene.setOnSceneTouchListener(paddle);)
 * in scene.
 */

public class PaddleView extends EntityView implements IOnSceneTouchListener {
	/**
	 * Model
	 */
	private PaddleModel entityModel;
	
	/**
	 * Controller
	 */
	private PaddleController entityController;
		
	private float mTouchX = 0, mTouchY = 0, mTouchOffsetX = 0, mTouchOffsetY = 0;

	/**
	 * Instantiate the PaddleView, PaddleModel and PaddleController
	 * 
	 @param pX X placement in screen
	 @param pY Y placement in screen
	 @param pTextureRegion 
	 @param touchArea Indicates the y height in the screen that is the paddle input. Andengine 
	 seems to have different coordinates for screen and touch coordinates. Bug? Therefore different
	 y value must be given than real screen position 
	 @param ark Refer to parent game
	 */
	public PaddleView(float pX, float pY, TextureRegion pTextureRegion, float touchArea, Arkanoid ark) {
		super(pX, pY, pTextureRegion);
		this.setEntityModel(new PaddleModel(pX, pY, touchArea, ark, this.getWidth(), this));
		this.setEntityController(new PaddleController(this.getEntityModel()));
		
		// TODO Auto-generated constructor stub
	}
	
	private PaddleModel getEntityModel() {
		return entityModel;
	}

	private void setEntityModel(PaddleModel entityModel) {
		this.entityModel = entityModel;
	}

	
	private PaddleController getEntityController() {
		return entityController;
	}

	private void setEntityController(PaddleController entityController) {
		this.entityController = entityController;
	}

	
	/**
	 * Interprets user touch input and sends the translated movement to the PaddleController.
	 * Set the new position based on updated values in the model.
	 * 
	 */
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		
		
		
		
		if(pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN)
        {
                
				mTouchX = pSceneTouchEvent.getMotionEvent().getX();
                mTouchY = pSceneTouchEvent.getMotionEvent().getY();
        }
        else if(pSceneTouchEvent.getAction() == MotionEvent.ACTION_MOVE)
        {
                float newX = pSceneTouchEvent.getMotionEvent().getX();
                float newY = pSceneTouchEvent.getMotionEvent().getY();
               
                /*
                Log.i("Andengine", String.valueOf(newY));
                Log.i("Andengine: paddleModel", String.valueOf(this.getEntityModel().getTouchArea()));
                */
                if (newY > this.getEntityModel().getTouchArea()){
                	mTouchOffsetX = (newX - mTouchX);
                    this.getEntityController().movementHandler(mTouchOffsetX);
                                }      
                mTouchX = newX;
                mTouchY = newY;
        }
        
		this.setPosition(this.getEntityModel().getX(),this.getEntityModel().getY());
		
		return true;
	}

	@Override
	public int[] collides(EntityView view) {
		// TODO Auto-generated method stub
		return this.getEntityController().collides(view);
	}
	
	

}
