package com.arkanoid;

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


        // ===========================================================

        // Fields

        // ===========================================================

 

        private Camera mCamera;
        private Texture mTexture;
        private TextureRegion mPaddleTextureRegion;
        private ChangeableText ScoreText;

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
            
            return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, 
                    new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera));

             
        }

 

        @Override
        public void onLoadResources() {
            
            this.mTexture = new Texture(128, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            this.mPaddleTextureRegion = TextureRegionFactory.createFromAsset(this.mTexture, this, "gfx/paddle.png", 0, 0);

            this.mEngine.getTextureManager().loadTexture(this.mTexture);

        }

        @Override
        public Scene onLoadScene() {
            
            this.mEngine.registerUpdateHandler(new FPSLogger());
            
            final Scene scene = new Scene(1);
            scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));

            /* Calculate the coordinates for the face, so its centered on the camera. */
            final int centerX = (CAMERA_WIDTH - this.mPaddleTextureRegion.getWidth()) / 2;
            final int centerY = (CAMERA_HEIGHT - this.mPaddleTextureRegion.getHeight()) / 4;

            /* Create the face and add it to the scene. */
            final Sprite paddle = new Sprite(centerX, centerY, this.mPaddleTextureRegion);
            paddle.setRotation(90.0f);
            scene.getLastChild().attachChild(paddle);

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