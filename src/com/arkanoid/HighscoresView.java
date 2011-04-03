package com.arkanoid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HighscoresView extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
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
	public void back(View v){
		finish();
	}

}
