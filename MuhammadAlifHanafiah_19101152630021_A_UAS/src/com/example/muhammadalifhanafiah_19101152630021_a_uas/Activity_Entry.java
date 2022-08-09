package com.example.muhammadalifhanafiah_19101152630021_a_uas;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class Activity_Entry extends Activity {

	TextView edit_noreg, edit_nama, edit_lama;
	Spinner sp_1;
	RadioGroup rg;
	RadioButton rd1, rd2;
	Button btn_simpan;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity__entry);
		
		/////////////////////////////////////////////////////
//		metode memanggil class spinner
		isi_spinner1();
		/////////////////////////////////////////////////////
		
		edit_noreg = (TextView)findViewById(R.id.edit_noreg);
		edit_nama = (TextView)findViewById(R.id.edit_nama);
		edit_lama = (TextView)findViewById(R.id.edit_lama);
		rg = (RadioGroup)findViewById(R.id.rg);
		rd1 = (RadioButton)findViewById(R.id.rd1);
		rd2 = (RadioButton)findViewById(R.id.rd2);
		
		btn_simpan = (Button)findViewById(R.id.btn_simpan);
		btn_simpan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String pilihan1 = "", Jawaban_spinner = "", Jawaban_radio = "";
				
				Spinner spinner_soal1 = (Spinner)findViewById(R.id.sp_1);
				
				pilihan1 = String.valueOf(spinner_soal1.getSelectedItem());
				
//				kondisi pemilihan jawaban spinner
				if (pilihan1.equalsIgnoreCase("UMUM")) {
					Jawaban_spinner = "UMUM";
				} else if (pilihan1.equalsIgnoreCase("MAHASISWA")) {
					Jawaban_spinner = "MAHASISWA";
				} else if (pilihan1.equalsIgnoreCase("DOSEN")) {
					Jawaban_spinner = "DOSEN";
				}
				
//				mengambil data text view
				String noreg = edit_noreg.getText().toString();
				String nama = edit_nama.getText().toString();
				String lama = edit_lama.getText().toString();
				
				
//				aktivasi radiogroup dan radiobutton
				if (rd1.isChecked()) {
					Jawaban_radio = "BACA BUKU";
				}
				if (rd2.isChecked()) {
					Jawaban_radio = "PINJAM BUKU";
				}
				
//				sebuah alert dialog untuk validasi jawaban
				AlertDialog.Builder peringatan = new AlertDialog.Builder(Activity_Entry.this);
				peringatan.setTitle("Validasi Jawaban");
				peringatan.setMessage("Keterangan Hasil Input Data:" 	+ "\n" +
								   	  "" 								+ "\n" +
								   	  "============================" 	+ "\n" +
								   	  "" 								+ "\n" +
								   	  "No Registrasi:"					+ "\n" +
								   	  "Tipe Pengunjung:"  				+ "\n" +
								   	  "Nama Pengunjung:"  				+ "\n" +
								   	  "Aktifitas Pengunjung:"  			+ "\n" +
								   	  "Lama Kunjungan:"  				+ "\n" +
								   	  "" 								+ "\n" +
									  "============================");
				peringatan.setNegativeButton("OK", null);
				peringatan.show();
				
				Intent pindah = new Intent(getApplicationContext(), Activity_Hasil.class);
				
//				parsing data dimulai dengan memperkenalkan variabel kiri pada setiap data yang ada
//				variabel kirim juga akan terhubung langsung dengan intent (pindah)
				pindah.putExtra("data_reg", noreg);
				pindah.putExtra("data_tipe", Jawaban_spinner);
				pindah.putExtra("data_nama", nama);
				pindah.putExtra("data_aktifitas", Jawaban_radio);
				pindah.putExtra("data_lama", lama);
				startActivity(pindah);
			}	
		});
		
		
	}

//	class isi spinner
	private void isi_spinner1() {
		sp_1 = (Spinner)findViewById(R.id.sp_1);
		List<String> list_jawaban_soal1 = new ArrayList<String>();
		list_jawaban_soal1.add("UMUM");
		list_jawaban_soal1.add("MAHASISWA");
		list_jawaban_soal1.add("DOSEN");
		
		ArrayAdapter<String> daftar_jawaban_soal1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list_jawaban_soal1);
		sp_1.setAdapter(daftar_jawaban_soal1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__entry, menu);
		return true;
	}

}
