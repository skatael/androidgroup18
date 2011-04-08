package com.arkanoid;

import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.opengl.texture.source.AssetTextureSource;
import org.anddev.andengine.opengl.texture.source.ITextureSource;
import org.anddev.andengine.ui.activity.BaseSplashActivity;

import android.app.Activity;

/**
 * @author Thomas Marstrander
 * A Splashscreen which plays before the mainmenu is opened.
 */
public class SplashScreen extends BaseSplashActivity {
	
    private static final int SPLASH_DURATION = 2;
    private static final float SPLASH_SCALE_FROM = 0.5f;

	@Override
	protected ScreenOrientation getScreenOrientation() {
        return ScreenOrientation.PORTRAIT;
	}

	@Override
	protected ITextureSource onGetSplashTextureSource() {
        return new AssetTextureSource(this, "gfx/arkanoid-screen1.png");
	}

	@Override
	protected float getSplashDuration() {
		return SPLASH_DURATION;
	}
	@Override
	protected float getSplashScaleFrom() {
		return SPLASH_SCALE_FROM;
	}

	@Override
	protected Class<? extends Activity> getFollowUpActivity() {
		return Menu.class;
	}

}
