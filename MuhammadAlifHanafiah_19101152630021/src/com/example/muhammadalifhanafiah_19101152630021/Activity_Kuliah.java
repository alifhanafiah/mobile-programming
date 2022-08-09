package com.example.muhammadalifhanafiah_19101152630021;

import com.example.alif_tab.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Activity_Kuliah extends Activity {

	Button btn_materi, btn_tugas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity__kuliah);
		
		btn_materi = (Button)findViewById(R.id.btn_materi);
		btn_materi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent pindahmaterikuliah = new Intent(arg0.getContext(), Activity_Materi.class);
				startActivityForResult(pindahmaterikuliah, 1);
				
			}
		});
		
		btn_tugas = (Button)findViewById(R.id.btn_tugas);
		btn_tugas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent pindahtugaskuliah = new Intent(arg0.getContext(), Activity_utama.class);
				startActivityForResult(pindahtugaskuliah, 1);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__kuliah, menu);
		return true;
	}

}
