package com.arkanoid;

import java.io.IOException;
import java.util.Stack;

import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.music.MusicFactory;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * 
 * @author Dahl
 * Main class of the game
 */

public class Arkanoid extends BaseGameActivity {

        // ===========================================================

        // Constants

        // ========================================================
		/**
		 * Width of the screen
		 */
        private static final int CAMERA_WIDTH = 480;
        /**
         * Height of the screen
         */
        private static final int CAMERA_HEIGHT = 800;
        /**
         * Speed of the ball
         */
        private static final float VELOCITY = 100.0f;
        /**
         * How many lives the player has
         */
        private static final int LIVES = 4;
       

        // ===========================================================

        // Fields

        // ===========================================================

        private Camera mCamera;
        
        //Paddle Textures
        private Texture pTexture;
        private TextureRegion mPaddleTextureRegion;
        
        //private Paddle paddle;
        private BlockController blockController;
        
        private BallView ball;
        
        //Ball Textures
        private Texture bTexture;
        private TextureRegion mBallTextureRegion;
        
        private Music mMusic;
        
        private ScoreBoard sb;
        
        
        private Texture mFontTexture;
        private Font mFont;

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
            // texturene m� settes i sine respektive klasser
            this.pTexture = new Texture(128, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            
            this.mPaddleTextureRegion = TextureRegionFactory.createFromAsset(this.pTexture, this, "gfx/paddle.png", 0, 0);
            
            bTexture = new Texture(32,32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            mBallTextureRegion = TextureRegionFactory.createFromAsset(this.bTexture, this, "gfx/ball.png", 0, 0);
            
			this.mEngine.getTextureManager().loadTextures(this.pTexture,this.bTexture);  
            blockController = new BlockController(this);
            
            //Adding music asset
            MusicFactory.setAssetBasePath("mfx/");
            try {
            	this.mMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "music.ogg");
            	this.mMusic.setLooping(true);
            } catch (final IOException e) {
            	e.printStackTrace();
            }

            //fontsetup
            this.mFontTexture = new Texture(256, 256, TextureOptions.BILINEAR);
            this.mFont = new Font(this.mFontTexture, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 24, true, Color.BLACK);
            this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
            this.mEngine.getFontManager().loadFont(this.mFont);
            //fontsetup
            
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
            
            //attach scoreboard
            sb = new ScoreBoard(scene, LIVES, this.getCAMERA_WIDTH(), 0);
            
            
            //this.paddle = new Paddle(centerX, centerY, this.mPaddleTextureRegion);
            //bug? touch area coordinates not the same as screen coordinates.
            //Workaround set value static for now
            final int touchArea = (440);
            final PaddleView paddle = new PaddleView(centerX,centerY,this.mPaddleTextureRegion,touchArea, this);
            //paddleview listens to touch events
            scene.setOnSceneTouchListener(paddle);
            
            //final Ball ball = new Ball(224,584, this.mBallTextureRegion,this);
             ball = new BallView(200, 300, this.mBallTextureRegion, this, centerY);
            
            //add listener to ball to check for collision
            //listener must extend EntityView
            ball.addListener(paddle);
           
            scene.getLastChild().attachChild(paddle);
            scene.getLastChild().attachChild(ball);
    
            final Block[] blocks = blockController.getBlocks();
            for(int i = 0; i <blocks.length;i++){
            	
            	scene.getLastChild().attachChild(blocks[i]);
            	ball.addListener(blocks[i]);
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
		/**
		 * 
		 * @return the velocity constant
		 */
		public float getVELOCITY(){
        	return VELOCITY;
        }
        /**
         * 
         * @return width of the screen
         */
        public int getCAMERA_WIDTH(){
        	return CAMERA_WIDTH;
        }
        /**
         * 
         * @return height of the screen
         */
        public int getCAMERA_HEIGHT(){
        	return CAMERA_HEIGHT;
        }
        /**
         * 
         * @return the ball
         */
        public BallView getBallView(){
			return ball;
		}
		
        /**
         * Method called by ball when it dies
         */
		public void die(){
			this.sb.die();
		}
		/**
		 * Method called to update score with new value
		 @param increase the increase to the score value
		 */
		public void updateScore(int increase){
			this.sb.updateScore(increase);
		}
		
        // ===========================================================

        // Inner and Anonymous Classes

        // ===========================================================

		/**
		 @author matsgora
		 * Inner class that handles the scoreboard and lives in the game.
		 */
		private class ScoreBoard {
			
			private long score;
			private Scene scene;
			private Stack<Sprite> livesStack;
			private int xpos, ypos;
			private ChangeableText scoreText;
			
			/**
			 * 
			 @param scene reference to the parent scene
			 @param lives number of lives
			 @param screenXpos screen y position of this score board
			 @param screenYpos screen y position of this score board
			 */
			public ScoreBoard(Scene scene, int lives, int screenXpos, int screenYpos){
				this.scene = scene;
				this.xpos = screenXpos;
				this.ypos = screenYpos;
				this.score = 0;
				initScore(this.scene);
				initLives(this.scene, lives);
			}
			
			/**
			 * Draws the score board during initialization
			 * 
			 @param scene the scene that this should be drawn in
			 @param numLives number of lives
			 */
			private void initLives(Scene scene, int numLives){
				this.livesStack = new Stack<Sprite>();
	            
	            for (int i = 0; i<numLives-1; i++){
	            	this.livesStack.push( new Sprite((this.xpos-mBallTextureRegion.getWidth())-i*mBallTextureRegion.getWidth(), this.ypos, mBallTextureRegion));
	            	scene.getLastChild().attachChild(this.livesStack.peek());
	            }
			}
			
			/**
			 * 
			 @param scene scene to init the text
			 */
			
			private void initScore(Scene scene){
				this.scoreText = new ChangeableText(0, 0, mFont, "Score: "+String.valueOf(this.score));
				this.scene.getLastChild().attachChild(scoreText);

			}
			
			/**
			 * Decrease a life when player dies
			 */
			public void decreaseLife(){
				runOnUpdateThread(new Runnable()
				{

					@Override
					public void run() {
						scene.getLastChild().detachChild(livesStack.pop());
						
					}
					
				});
			}
			
			/**
			 * Increases life of player when needed.
			 */
			public void increaseLife(){
				runOnUpdateThread(new Runnable()
				{

					@Override
					public void run() {
						livesStack.push( new Sprite((livesStack.peek().getX()-mBallTextureRegion.getWidth()), ypos, mBallTextureRegion));
						scene.getLastChild().attachChild(livesStack.peek());
						
					}
					
				});
			}
			/**
			 * Handles updating of the score
			 @param value the increase to the score
			 */
			public void updateScore(int value){
				this.score = this.score+value;
				runOnUpdateThread(new Runnable()
				{

					@Override
					public void run() {
                        scoreText.setText("Score: "+String.valueOf(score));
					}
					
				});
				
			}
			
			
			/**
			 * This is called each time the player dies. Number of remaining lives are checked and
			 * player is directed to highscore registration if the score is within the highscorelist,
			 * else to the main menu.
			 */
			public void die(){
				this.decreaseLife();
				if (this.livesStack.isEmpty()){
					Log.i("Arkanoid", "Game over");
					Log.i("Arkanoid", "ScoreBoard die to handle no more lives");
					Highscore hs = new Highscore(Arkanoid.this);
					if(this.score > hs.getScore(9)){
						Intent entername = new Intent(Arkanoid.this, EnterName.class);
						entername.putExtra("score", score);
						startActivity(entername);
					}
					finish();
				}
			}			
			
		}
		
		public BlockController getBlockController(){
			return blockController;
		}

}