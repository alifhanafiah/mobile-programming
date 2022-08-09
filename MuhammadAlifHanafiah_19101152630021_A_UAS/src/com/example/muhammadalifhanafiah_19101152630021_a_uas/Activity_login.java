package com.example.muhammadalifhanafiah_19101152630021_a_uas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_login extends Activity {

	EditText edit_user, edit_pass;
	Button btn_login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_login);
		
		edit_user = (EditText)findViewById(R.id.edit_user);
		edit_pass = (EditText)findViewById(R.id.edit_pass);
		
		btn_login = (Button)findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String Nama = edit_user.getText().toString();
				String Pass = edit_pass.getText().toString();
				
				if (Nama.equals("admin")&&Pass.equals("admin")) {
					Intent pindahmenu = new Intent(arg0.getContext(), Activity_menu.class);
					startActivityForResult(pindahmenu, 1);
				} else {
					Toast.makeText(getApplicationContext(),
							"Password atau username salah",
							Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

}
