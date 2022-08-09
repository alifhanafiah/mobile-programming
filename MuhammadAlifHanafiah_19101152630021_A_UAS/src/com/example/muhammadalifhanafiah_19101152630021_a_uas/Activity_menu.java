package com.example.muhammadalifhanafiah_19101152630021_a_uas;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.app.TabActivity; // tambahkan file header tab activity
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Activity_menu extends TabActivity { // ganti activity menjadi tab activity

	TabHost tabmenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_menu);
		
		tabmenu = getTabHost();
		
		TabSpec ts1 = tabmenu.newTabSpec("Hal 1");
		ts1.setIndicator("Data");
		ts1.setContent(new Intent(this, Activity_Entry.class));
		tabmenu.addTab(ts1);
		
		TabSpec ts2 = tabmenu.newTabSpec("Hal 2");
		ts2.setIndicator("Hasil");
		ts2.setContent(new Intent(this, Activity_Hasil.class));
		tabmenu.addTab(ts2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}

}
