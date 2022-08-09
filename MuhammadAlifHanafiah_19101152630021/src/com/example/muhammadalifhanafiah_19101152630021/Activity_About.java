package com.example.muhammadalifhanafiah_19101152630021;

import com.example.alif_tab.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Activity_About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity__about);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__about, menu);
		return true;
	}

}
