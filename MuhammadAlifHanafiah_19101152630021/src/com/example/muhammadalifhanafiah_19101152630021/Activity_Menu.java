package com.example.muhammadalifhanafiah_19101152630021;

import com.example.alif_tab.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.app.TabActivity; // tambahkan file header tab activity
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Activity_Menu extends TabActivity { // ganti activity menjadi tab activity

	TabHost tabmenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity__menu);
		
		tabmenu = getTabHost();
		
		TabSpec ts1 = tabmenu.newTabSpec("Hal 1");
		ts1.setIndicator("Profile");
		ts1.setContent(new Intent(this, Activity_Profile.class));
		tabmenu.addTab(ts1);
		
		TabSpec ts2 = tabmenu.newTabSpec("Hal 2");
		ts2.setIndicator("Social");
		ts2.setContent(new Intent(this, Activity_Ig.class));
		tabmenu.addTab(ts2);
		
		TabSpec ts3 = tabmenu.newTabSpec("Hal 3");
		ts3.setIndicator("Kuliah");
		ts3.setContent(new Intent(this, Activity_Kuliah.class));
		tabmenu.addTab(ts3);
		
		TabSpec ts4 = tabmenu.newTabSpec("Hal 4");
		ts4.setIndicator("About");
		ts4.setContent(new Intent(this, Activity_About.class));
		tabmenu.addTab(ts4);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__menu, menu);
		return true;
	}

}
