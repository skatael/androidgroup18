package com.arkanoid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Credits extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.creds);
	}
	public void back(View v){
		finish();
	}

}
