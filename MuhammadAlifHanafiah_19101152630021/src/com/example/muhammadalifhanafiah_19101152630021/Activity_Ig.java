package com.example.muhammadalifhanafiah_19101152630021;

import com.example.alif_tab.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Activity_Ig extends Activity {

	private void tampilweb(String url){
		WebView webviewku = (WebView)findViewById(R.id.web);
		webviewku.loadUrl(url);
		webviewku.getSettings().setJavaScriptEnabled(true);
		webviewku.setWebViewClient(new WebViewClient());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity__ig);
		
		tampilweb("https://www.instagram.com/alifff_hanafiah/");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__ig, menu);
		return true;
	}

}
