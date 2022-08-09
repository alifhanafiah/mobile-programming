package com.example.quiz_a;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity_soal extends Activity {
Button btn_proses;
RadioGroup rg;
RadioButton rd1, rd2, rd3, rd4;

String jawaban = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_soal);
		
		rg = (RadioGroup)findViewById(R.id.rg);
		rd1 = (RadioButton)findViewById(R.id.rd1);
		rd2 = (RadioButton)findViewById(R.id.rd2);
		rd3 = (RadioButton)findViewById(R.id.rd3);
		rd4 = (RadioButton)findViewById(R.id.rd4);
		
		btn_proses = (Button)findViewById(R.id.btn_proses);
		btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
//				aktivasi radiogroup dan radiobutton
				if (rd1.isChecked()) {
					jawaban = "benar";
				}
				if (rd2.isChecked()) {
					jawaban = "salah";
				}
				if (rd3.isChecked()) {
					jawaban = "salah";
				}
				if (rd4.isChecked()) {
					jawaban = "salah";
				}
				
				Intent pindah = new Intent(getApplicationContext(), Activity_data.class);
				
//				parsing data dimulai dengan memperkenalkan variabel kiri pada setiap data yang ada
//				variabel kirim juga akan terhubung langsung dengan intent (pindah)
				pindah.putExtra("data_jawaban", jawaban);
				startActivity(pindah);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_soal, menu);
		return true;
	}

}
