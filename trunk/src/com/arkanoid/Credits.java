package com.arkanoid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Thomas Marstrander
 *
 * Credits screen displaying the authors of this game.
 */
public class Credits extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.creds);
	}
	/**
	 * @param v The current view.
	 * the onClick action of a button that returns you to the main menu.
	 */
	public void back(View v){
		finish();
	}

}
