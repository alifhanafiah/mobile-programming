package com.example.parsing_data;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText edit_bp, edit_nama;
	Button btn_proses;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edit_bp = (EditText)findViewById(R.id.edit_bp);
		edit_nama = (EditText)findViewById(R.id.edit_nama);
		
		btn_proses = (Button)findViewById(R.id.btn_proses);
		btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent pindah = new Intent(getApplicationContext(), Activity_Data.class);
				
//				parsing data dimulai dengan memperkenalkan variabel kiri pada setiap data yang ada
//				variabel kirim juga akan terhubung langsung dengan intent (pindah)
				pindah.putExtra("data_nobp", edit_bp.getText().toString());
				pindah.putExtra("data_nama", edit_nama.getText().toString());
				startActivity(pindah);
				edit_bp.setText("");
				edit_nama.setText("");
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
