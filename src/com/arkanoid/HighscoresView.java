package com.arkanoid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Thomas Marstrander
 * 
 * A screen which displays current highscores.
 *
 */
public class HighscoresView extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Highscore hs = new Highscore(this);
		setContentView(R.layout.highscores);
		ViewGroup leftlayout = (ViewGroup) findViewById(R.id.linearLayout1);
		ViewGroup rightlayout = (ViewGroup) findViewById(R.id.linearLayout2);
		for(int i=0; i<10; i++){
			int position = i+1;
			TextView name = new TextView(this);
			name.setText(position+". "+hs.getName(i));
			leftlayout.addView(name);
			TextView score = new TextView(this);
			score.setText(""+hs.getScore(i));
			rightlayout.addView(score);
		}

	}
	/**
	 * @param v the current view
	 * the onClick action of a button that returns you to the main menu.
	 */
	public void back(View v){
		finish();
	}

}
