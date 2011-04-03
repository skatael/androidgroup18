package com.arkanoid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
	}
	public void newGame(View v){
		Intent game = new Intent(this, Arkanoid.class);
		startActivity(game);
	}
	public void highscore(View v){
		Intent hs = new Intent(this, HighscoresView.class);
		startActivity(hs);
	}
	public void creds(View v){
		Intent creds = new Intent(this, Credits.class);
		startActivity(creds);
	}
	// trengs egentlig ikke.
	public void exit(View v){
		finish();
	}

}
