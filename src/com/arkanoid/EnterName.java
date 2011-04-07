package com.arkanoid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * @author Thomas Marstrander
 * Screen for registering a new highscore.
 *
 */
public class EnterName extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enterscore);
	}
	/**
	 * @param v
	 * Sets the new highscore and changes screen to HighscoreView.
	 * Returns the user to previous screen when HighscoreView is finished.
	 */
	public void highscorelist(View v){
		EditText namefield = (EditText)(findViewById(R.id.editText1));
		String name = namefield.getText().toString();
		Highscore hs = new Highscore(this);
		Intent scoreintent = getIntent();
		int score = (int) scoreintent.getLongExtra("score", 0);
		hs.addScore(name, score);
		Intent highscore = new Intent(this, HighscoresView.class);
		startActivity(highscore);
		finish();
	}
	
}