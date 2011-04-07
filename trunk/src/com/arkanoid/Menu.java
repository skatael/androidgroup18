package com.arkanoid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @author Thomas Marstrander
 * Mainmenu for the game.
 */
public class Menu extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
	}
	/**
	 * @param v Current view
	 * the onClick action of a button that starts the game screen(Arkanoid) with a new game.
	 */
	public void newGame(View v){
		Intent game = new Intent(this, Arkanoid.class);
		startActivity(game);
	}
	/**
	 * @param v Current view
	 * the onClick action of a button that sends you to the HighscoresView screen.
	 */
	public void highscore(View v){
		Intent hs = new Intent(this, HighscoresView.class);
		startActivity(hs);
	}
	/**
	 * @param v Current view
	 * the onClick action of a button that sends you to the Credits screen.
	 */
	public void creds(View v){
		Intent creds = new Intent(this, Credits.class);
		startActivity(creds);
	}
	/**
	 * @param v Current view
	 * finishes the current activity and returns you to the previous unfinished screen.
	 */
	public void exit(View v){
		finish();
	}

}
