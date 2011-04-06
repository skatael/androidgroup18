package com.arkanoid;

import java.io.IOException;

import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.music.MusicFactory;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.content.Intent;
import android.util.Log;



public class Arkanoid extends BaseGameActivity {

        // ===========================================================

        // Constants

        // ========================================================
        private static final int CAMERA_WIDTH = 480;
        private static final int CAMERA_HEIGHT = 800;
        
        private static final float VELOCITY = 100.0f;
        
        private BlockController blockController;
        
        private Music mMusic;
        
        private int lives;
        private int score;

        
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
        
        private Paddle paddle;
        
        
        //Ball Textures
        private Texture bTexture;
        private TextureRegion mBallTextureRegion;
        
        

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
                    new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera).setNeedsMusic(true));

             
        }

 

        @Override
        public void onLoadResources() {
            // texturene må settes i sine respektive klasser
            this.pTexture = new Texture(128, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            this.mPaddleTextureRegion = TextureRegionFactory.createFromAsset(this.pTexture, this, "gfx/paddle.png", 0, 0);
            
            bTexture = new Texture(32,32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            mBallTextureRegion = TextureRegionFactory.createFromAsset(this.bTexture, this, "gfx/ball.png", 0, 0);
            
			this.mEngine.getTextureManager().loadTextures(this.pTexture,this.bTexture);  
            blockController = new BlockController(this);
            
            MusicFactory.setAssetBasePath("mfx/");
            try {
                    this.mMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "music.ogg");
                    this.mMusic.setLooping(true);
                    Log.i("Android music", "Wohoo");
            } catch (final IOException e) {
                Log.i("Android music", "nooooo");

            	e.printStackTrace();
            }

            this.lives = 3;
            
    		
            this.mEngine.getTextureManager().loadTextures(this.pTexture,this.bTexture,this.bTexture);

        }

        @Override
        public Scene onLoadScene() {
            
            this.mEngine.registerUpdateHandler(new FPSLogger());
            
            final Scene scene = new Scene(1);
            scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));
            //scene.setOnSceneTouchListener(this);

            /* Calculate the coordinates for the face, so its centered on the camera. */
            final int centerX = (CAMERA_WIDTH - this.mPaddleTextureRegion.getWidth()) / 2;
            final int centerY = (700);

            /* Create the face and add it to the scene. */
            //this.paddle = new Paddle(centerX, centerY, this.mPaddleTextureRegion);
            //bug? touch area coordinates not the same as screen coordinates.
            //Workaround set value static for now
            final int touchArea = (440);
            final PaddleView paddle = new PaddleView(centerX,centerY,this.mPaddleTextureRegion,touchArea, this);
            //paddleview listens to touch events
            scene.setOnSceneTouchListener(paddle);
            
            //final Ball ball = new Ball(224,584, this.mBallTextureRegion,this);
            final BallView ball = new BallView(200, 300, this.mBallTextureRegion, this, centerY);
            
            //add listener to ball to check for collision
            //listener must extend EntityView
            ball.addListener(paddle);
           
            scene.getLastChild().attachChild(paddle);
            scene.getLastChild().attachChild(ball);
    
            final Block[] blocks = blockController.getBlocks();
            for(int i = 0; i <blocks.length;i++){
            	
            	scene.getLastChild().attachChild(blocks[i]);
            }
            
            //this.mMusic.play();
            return scene;

        }
      

		@Override
        public void onLoadComplete() {
 

        }
       

		


 

        // ===========================================================

        // Methods

        // ===========================================================
		public void die(){
			this.lives = this.lives -1;
			if (this.lives == 0){
				Log.i("Arkanoid", "Game over");
				Intent hs = new Intent(this, HighscoresView.class);
				startActivity(hs);
				
			}
		}
		

        // ===========================================================

        // Inner and Anonymous Classes

        // ===========================================================


}