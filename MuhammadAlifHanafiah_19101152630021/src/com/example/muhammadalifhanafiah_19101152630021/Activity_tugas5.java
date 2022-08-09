package com.example.muhammadalifhanafiah_19101152630021;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
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

import com.example.alif_tab.R;

public class Activity_tugas5 extends Activity {
//	pengenalan id
	Spinner sp_1, sp_2, sp_3;
	Button btn_proses, btn_back5;
	TextView Jawaban;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_tugas5);
		
		/////////////////////////////////////////////////////
//		metode memanggil class spinner
		isi_spinner1();
		isi_spinner2();
		isi_spinner3();
		/////////////////////////////////////////////////////
		
		Jawaban = (TextView)findViewById(R.id.Jawaban);
		btn_proses = (Button)findViewById(R.id.btn_proses);
		btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String pilihan1 = "", pilihan2 = "", pilihan3 = "";
				
				String Status_jawaban1 = "", Status_jawaban2 = "", Status_jawaban3 = "";
				
				Spinner spinner_soal1 = (Spinner)findViewById(R.id.sp_1);
				Spinner spinner_soal2 = (Spinner)findViewById(R.id.sp_2);
				Spinner spinner_soal3 = (Spinner)findViewById(R.id.sp_3);
				pilihan1 = String.valueOf(spinner_soal1.getSelectedItem());
				pilihan2 = String.valueOf(spinner_soal2.getSelectedItem());
				pilihan3 = String.valueOf(spinner_soal3.getSelectedItem());
				
//				kondisi pemilihan jawaban spinner
//				spinner 1
				if (pilihan1.equalsIgnoreCase("A. Harimau")) {
					Status_jawaban1 = "Salah";
				} else if (pilihan1.equalsIgnoreCase("B. Gajah")) {
					Status_jawaban1 = "Salah";
				} else if (pilihan1.equalsIgnoreCase("C. Elang")) {
					Status_jawaban1 = "Benar";
				} else if (pilihan1.equalsIgnoreCase("D. Kerbau"))  {
					Status_jawaban1 = "Salah";
				}
				
//				spinner 2
				if (pilihan2.equalsIgnoreCase("A. Hijau")) {
					Status_jawaban2 = "Benar";
				} else if (pilihan2.equalsIgnoreCase("B. Biru")) {
					Status_jawaban2 = "Salah";
				} else if (pilihan2.equalsIgnoreCase("C. Putih")) {
					Status_jawaban2 = "Salah";
				} else if (pilihan2.equalsIgnoreCase("D. Ungu"))  {
					Status_jawaban2 = "Salah";
				}
				
//				spinner 3
				if (pilihan3.equalsIgnoreCase("A. Mendengar")) {
					Status_jawaban3 = "Salah";
				} else if (pilihan3.equalsIgnoreCase("B. Meraba")) {
					Status_jawaban3 = "Salah";
				} else if (pilihan3.equalsIgnoreCase("C. Melihat")) {
					Status_jawaban3 = "Benar";
				} else if (pilihan3.equalsIgnoreCase("D. Pengecap"))  {
					Status_jawaban3 = "Salah";
				}
				
//				sebuah alert dialog untuk validasi jawaban
				AlertDialog.Builder peringatan = new AlertDialog.Builder(Activity_tugas5.this);
				peringatan.setTitle("Score Jawaban");
				peringatan.setMessage("Jawaban 1 : " + Status_jawaban1 + "\n" +
									  "Jawaban 2 : " + Status_jawaban2 + "\n" +
									  "Jawaban 3 : " + Status_jawaban3);
				peringatan.setNegativeButton("OK", null);
				peringatan.show();
				
				Jawaban.setText("Jawaban 1 : " + Status_jawaban1 + "\n" +
						  		"Jawaban 2 : " + Status_jawaban2 + "\n" +
						  		"Jawaban 3 : " + Status_jawaban3);
			}
		});
		
        btn_back5 = (Button)findViewById(R.id.btn_back5);
        btn_back5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent pindahtugas5 = new Intent();
				setResult(RESULT_OK, pindahtugas5);
				finish();
			}
		});
	}

//	class isi spinner
	private void isi_spinner1() {
		sp_1 = (Spinner)findViewById(R.id.sp_1);
		List<String> list_jawaban_soal1 = new ArrayList<String>();
		list_jawaban_soal1.add("A. Harimau");
		list_jawaban_soal1.add("B. Gajah");
		list_jawaban_soal1.add("C. Elang");
		list_jawaban_soal1.add("D. Kerbau");
		
		ArrayAdapter<String> daftar_jawaban_soal1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list_jawaban_soal1);
		sp_1.setAdapter(daftar_jawaban_soal1);
	}
	private void isi_spinner2() {
		sp_2 = (Spinner)findViewById(R.id.sp_2);
		List<String> list_jawaban_soal2 = new ArrayList<String>();
		list_jawaban_soal2.add("A. Hijau");
		list_jawaban_soal2.add("B. Biru");
		list_jawaban_soal2.add("C. Putih");
		list_jawaban_soal2.add("D. Ungu");
		
		ArrayAdapter<String> daftar_jawaban_soal2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list_jawaban_soal2);
		sp_2.setAdapter(daftar_jawaban_soal2);
	}
	private void isi_spinner3() {
		sp_3 = (Spinner)findViewById(R.id.sp_3);
		List<String> list_jawaban_soal3 = new ArrayList<String>();
		list_jawaban_soal3.add("A. Mendengar");
		list_jawaban_soal3.add("B. Meraba");
		list_jawaban_soal3.add("C. Melihat");
		list_jawaban_soal3.add("D. Pengecap");
		
		ArrayAdapter<String> daftar_jawaban_soal1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list_jawaban_soal3);
		sp_3.setAdapter(daftar_jawaban_soal1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
