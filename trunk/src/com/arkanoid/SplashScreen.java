package com.arkanoid;

import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.opengl.texture.source.AssetTextureSource;
import org.anddev.andengine.opengl.texture.source.ITextureSource;
import org.anddev.andengine.ui.activity.BaseSplashActivity;

import android.app.Activity;

public class SplashScreen extends BaseSplashActivity {
	
    private static final int SPLASH_DURATION = 2;
    private static final float SPLASH_SCALE_FROM = 0.5f;

	@Override
	protected ScreenOrientation getScreenOrientation() {
		// TODO Auto-generated method stub
        return ScreenOrientation.PORTRAIT;
	}

	@Override
	protected ITextureSource onGetSplashTextureSource() {
		// TODO Auto-generated method stub
        return new AssetTextureSource(this, "gfx/arkanoid-screen1.png");
	}

	@Override
	protected float getSplashDuration() {
		// TODO Auto-generated method stub
		return SPLASH_DURATION;
	}
	@Override
	protected float getSplashScaleFrom() {
		// TODO Auto-generated method stub
		return SPLASH_SCALE_FROM;
	}

	@Override
	protected Class<? extends Activity> getFollowUpActivity() {
		// TODO Auto-generated method stub
		return Menu.class;
	}

}
