package com.arkanoid;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import android.util.Log;
import android.view.MotionEvent;


public class PaddleView extends EntityView implements IOnSceneTouchListener {

	private PaddleModel entityModel;
	private PaddleController entityController;
		
	private float mTouchX = 0, mTouchY = 0, mTouchOffsetX = 0, mTouchOffsetY = 0;

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
