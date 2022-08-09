package com.example.coba;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {
	
	TabHost th;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Resources rsc = getResources();
        th = (TabHost)findViewById(R.id.th);
        
        th.setup();
        TabSpec ts1 = th.newTabSpec("tab 1");
        ts1.setContent(R.id.ts1);
        ts1.setIndicator("Profile");
        th.addTab(ts1);
        
        TabSpec ts2 = th.newTabSpec("tab 2");
        ts2.setContent(R.id.ts2);
        ts2.setIndicator("Social Media", rsc.getDrawable(android.R.drawable.ic_menu_gallery));
        th.addTab(ts2);
        
        TabSpec tab3 = th.newTabSpec("tab 3");
        tab3.setContent(R.id.tab3);
        tab3.setIndicator("Testing");
        th.addTab(tab3);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
