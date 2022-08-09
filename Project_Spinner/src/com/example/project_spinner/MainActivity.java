package com.example.project_spinner;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;


import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Button;

// file header yang dibutuhkan spinner
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

// file header untuk tampilan spinner
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
//	pengenalan id
	Spinner sp_1;
	Button btn_proses;
	TextView Jawaban1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/////////////////////////////////////////////////////
//		metode memanggil class spinner
		isi_spinner1();
		/////////////////////////////////////////////////////
		
		Jawaban1 = (TextView)findViewById(R.id.Jawaban1);
		btn_proses = (Button)findViewById(R.id.btn_proses);
		btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String pilihan1 = "";
				
				int Status_jawaban = 0;
				
				Spinner spinner_soal1 = (Spinner)findViewById(R.id.sp_1);
				pilihan1 = String.valueOf(spinner_soal1.getSelectedItem());
				
//				kondisi pemilihan jawaban spinner
				if (pilihan1.equalsIgnoreCase("A. Harimau")) {
					Status_jawaban = 0;
				} else if (pilihan1.equalsIgnoreCase("B. Buaya")) {
					Status_jawaban = 0;
				} else if (pilihan1.equalsIgnoreCase("C. Elang")) {
					Status_jawaban = 100;
				} else if (pilihan1.equalsIgnoreCase("D. Kerbau"))  {
					Status_jawaban = 0;
				}
				
//				sebuah alert dialog untuk validasi jawaban
				AlertDialog.Builder peringatan = new AlertDialog.Builder(MainActivity.this);
				peringatan.setTitle("Validasi Jawaban");
				peringatan.setMessage("Jawaban : " + Status_jawaban);
				peringatan.setNegativeButton("OK", null);
				peringatan.show();
				
				Jawaban1.setText("Jawaban : " + Status_jawaban);
			}
		});
	}

//	class isi spinner
	private void isi_spinner1() {
		sp_1 = (Spinner)findViewById(R.id.sp_1);
		List<String> list_jawaban_soal1 = new ArrayList<String>();
		list_jawaban_soal1.add("A. Harimau");
		list_jawaban_soal1.add("B. Buaya");
		list_jawaban_soal1.add("C. Elang");
		list_jawaban_soal1.add("D. Kerbau");
		
		ArrayAdapter<String> daftar_jawaban_soal1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list_jawaban_soal1);
		sp_1.setAdapter(daftar_jawaban_soal1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
