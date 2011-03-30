package com.arkanoid;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;


public class Arkanoid extends BaseGameActivity {

        // ===========================================================

        // Constants

        // ========================================================
        private static final int CAMERA_WIDTH = 480;
        private static final int CAMERA_HEIGHT = 800;
        
        private static final float VELOCITY = 100.0f;
        
        public float getVELOCITY(){
        	return VELOCITY;
        }
        
        public int getCAMERA_WIDTH(){
        	return CAMERA_WIDTH;
        }
        
        public int getCAMERA_HEIGHT(){
        	return CAMERA_HEIGHT;
        }


        // ===========================================================

        // Fields

        // ===========================================================

 

        private Camera mCamera;
        
        //Paddle Textures
        private Texture pTexture;
        private TextureRegion mPaddleTextureRegion;
        
        //Ball Textures
        private Texture bTexture;
        private TextureRegion mBallTextureRegion;
        
        //Block Textures
        private Texture blTexture;
        private TextureRegion mBlockTextureRegion;
        
        
        //Block textures

       // ===========================================================

        // Constructors

        // ===========================================================

 

        // ===========================================================

        // Getter & Setter

        // ===========================================================

 

        // ===========================================================

        // Methods for/from SuperClass/Interfaces

        // ===========================================================

 

        @Override
        public Engine onLoadEngine() {
                       
            this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
//            mCamera.
            
            return new Engine(new EngineOptions(true, ScreenOrientation.PORTRAIT, 
                    new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera));

             
        }

 

        @Override
        public void onLoadResources() {
            // texturene må settes i sine respektive klasser
            this.pTexture = new Texture(128, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            this.mPaddleTextureRegion = TextureRegionFactory.createFromAsset(this.pTexture, this, "gfx/paddle.png", 0, 0);
            
            bTexture = new Texture(32,32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            mBallTextureRegion = TextureRegionFactory.createFromAsset(this.bTexture, this, "gfx/ball.png", 0, 0);
            
            blTexture = new Texture(128, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            mBlockTextureRegion = TextureRegionFactory.createFromAsset(this.blTexture, this, "gfx/block.png", 0, 0);
      

            this.mEngine.getTextureManager().loadTexture(this.pTexture);
            this.mEngine.getTextureManager().loadTexture(this.bTexture);
            this.mEngine.getTextureManager().loadTexture(this.blTexture);

        }

        @Override
        public Scene onLoadScene() {
            
            this.mEngine.registerUpdateHandler(new FPSLogger());
            
            final Scene scene = new Scene(1);
            scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));

            /* Calculate the coordinates for the face, so its centered on the camera. */
            final int centerX = (CAMERA_WIDTH - this.mPaddleTextureRegion.getWidth()) / 2;
            final int centerY = (700);

            /* Create the face and add it to the scene. */
            final Paddle paddle = new Paddle(centerX, centerY, this.mPaddleTextureRegion);
            final Ball ball = new Ball(224,584, this.mBallTextureRegion,this);
            final Block[] blocks= new Block[3];
            int xPos = 40;
            int yPos = 50;
            
            for(int i = 0; i <blocks.length;i++){
            	blocks[i] = new Block(xPos, yPos, this.mBlockTextureRegion);
            	xPos+=128;
            	scene.getLastChild().attachChild(blocks[i]);
            }
            
            final PhysicsHandler physicsHandler = new PhysicsHandler(ball);
            ball.registerUpdateHandler(physicsHandler);
            physicsHandler.setVelocity(VELOCITY, VELOCITY);
            
            scene.getLastChild().attachChild(paddle);
            scene.getLastChild().attachChild(ball);
            
            return scene;

        }
        @Override
        public void onLoadComplete() {
 

        }

 

        // ===========================================================

        // Methods

        // ===========================================================

 

        // ===========================================================

        // Inner and Anonymous Classes

        // ===========================================================


}