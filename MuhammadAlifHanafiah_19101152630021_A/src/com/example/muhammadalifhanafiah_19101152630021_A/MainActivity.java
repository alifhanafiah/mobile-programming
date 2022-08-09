package com.example.muhammadalifhanafiah_19101152630021_A;

import com.example.project_6.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

//file header yang dibutuhkan spinner
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

//file header untuk tampilan spinner
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

//	kenalkan semua komponen yang memiliki id
	EditText edit_no, edit_nama, edit_tanggal, edit_telepon;
	RadioGroup rg;
	RadioButton rd1, rd2;
	CheckBox cb1, cb2, cb3, cb4;
	ListView ls;
	Button btn_proses;
	TextView txt_hasil;
	Spinner sp_1;
	
//	variabel untuk edit id dan nama
	String Data_no, Data_nama, Data_tanggal, Data_telepon = null;
	int kondisiHargaTiket, totalBayar = 0;
	String Data_pilihan_jk = null;
	String Data_pilihan_item = null;
	
//	isian dari list
	String [] daftar_topik = {"PEMOGRAMAN WEB DASAR",
							 "FRONT-END DAN PATH CAREERNYA",
							 "BERBAGAI FRAMEWORK BACK-END",
							 "MEMAHAMI FULLSTACK",
							 "PEMOGRAMAN ANDROID",
							 "PENTINGNYA UI/UX"};
	String pilihan_topik = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/////////////////////////////////////////////////////
//		metode memanggil class spinner
		isi_spinner1();
		/////////////////////////////////////////////////////
		
//		deklarasikan
		edit_no = (EditText)findViewById(R.id.edit_no);
		edit_nama = (EditText)findViewById(R.id.edit_nama);
		edit_tanggal = (EditText)findViewById(R.id.edit_tanggal);
		edit_telepon = (EditText)findViewById(R.id.edit_telepon);
		rg = (RadioGroup)findViewById(R.id.rg);
		rd1 = (RadioButton)findViewById(R.id.rd1);
		rd2 = (RadioButton)findViewById(R.id.rd2);
		cb1 = (CheckBox)findViewById(R.id.cb1);
		cb2 = (CheckBox)findViewById(R.id.cb2);
		cb3 = (CheckBox)findViewById(R.id.cb3);
		cb4 = (CheckBox)findViewById(R.id.cb4);
		ls = (ListView)findViewById(R.id.ls);
		btn_proses = (Button)findViewById(R.id.btn_proses);
		txt_hasil = (TextView)findViewById(R.id.txt_hasil);
		
		
//		adapter list (penghubung isian dengan design list)
		ArrayAdapter<String> konektor_list = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, daftar_topik);
		ls.setAdapter(konektor_list);
		
//		proses dari list
		ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
//				aktifkan tampung data id dan nama
				Data_no = String.valueOf(edit_no.getText().toString());
				Data_nama = String.valueOf(edit_nama.getText().toString());
				Data_tanggal = String.valueOf(edit_tanggal.getText().toString());
				Data_telepon = String.valueOf(edit_telepon.getText().toString());
				
//				aktivasi radiogroup dan radiobutton
				if (rd1.isChecked()) {
					Data_pilihan_jk = rd1.getText().toString();
				}
				if (rd2.isChecked()) {
					Data_pilihan_jk = rd2.getText().toString();
				}
				
//				aktifasi checkbox
				if (cb1.isChecked()) {
					Data_pilihan_item = cb1.getText().toString();
					kondisiHargaTiket = 30000;
				}
				if (cb2.isChecked()) {
					Data_pilihan_item = cb2.getText().toString();
					kondisiHargaTiket = 60000;
				}
				if (cb3.isChecked()) {
					Data_pilihan_item = cb3.getText().toString();
					kondisiHargaTiket = 90000;
				}
				if (cb4.isChecked()) {
					Data_pilihan_item = cb4.getText().toString();
					kondisiHargaTiket = 110000;
				}
				
				pilihan_topik = String.valueOf(daftar_topik[position]);
				
//				buatkan validasi pilihan
				AlertDialog.Builder validasi_pilihan_film = new AlertDialog.Builder(MainActivity.this);
				validasi_pilihan_film.setTitle("Validasi data pilihan");
				validasi_pilihan_film.setMessage("No Registrasi : " 		+ Data_no 				+ "\n" +
												 "Nama : " 					+ Data_nama 			+ "\n" +
												 "Jenis Kelamin : " 		+ Data_pilihan_jk		+ "\n" +
												 "Paket : " 				+ Data_pilihan_item		+ "\n" +
												 "Tanggal Pendaftaran : " 	+ Data_tanggal	 		+ "\n" +
												 "No Telepon : "			+ Data_telepon		 	+ "\n" +
												 "Topik Webinar : " 		+ pilihan_topik 		+ "\n" +
												 "================================="				+ "\n" +
												 "apakah data pilihan di atas sudah benar?");
				validasi_pilihan_film.setNeutralButton("OKE", null);
				validasi_pilihan_film.show();
			}
			
		});
		
/////////////////////////////////////////////////////////////////////////////////////////////
		
//		aktifkan button
		btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String pilihan1 = "";
				
				int biaya_admin = 0;
				
				Spinner spinner_soal1 = (Spinner)findViewById(R.id.sp_1);
				pilihan1 = String.valueOf(spinner_soal1.getSelectedItem());
				
//				aktifkan tampung data id dan nama
				Data_no = String.valueOf(edit_no.getText().toString());
				Data_nama = String.valueOf(edit_nama.getText().toString());
				
//				kondisi pemilihan jawaban spinner
				if (pilihan1.equalsIgnoreCase("BRI")) {
					biaya_admin = 5000;
				} else if (pilihan1.equalsIgnoreCase("BCA")) {
					biaya_admin = 2500;
				} else if (pilihan1.equalsIgnoreCase("MANDIRI")) {
					biaya_admin = 10000;
				} else if (pilihan1.equalsIgnoreCase("NAGARI"))  {
					biaya_admin = 0;
				} else if (pilihan1.equalsIgnoreCase("BTN")) {
					biaya_admin = 1500;
				} else if (pilihan1.equalsIgnoreCase("BNI")) {
					biaya_admin = 3000;
				} else if (pilihan1.equalsIgnoreCase("CIMB")) {
					biaya_admin = 1000;
				} else if (pilihan1.equalsIgnoreCase("BUKOPIN SYARIAH"))  {
					biaya_admin = 2500;
				}
				
//				aktivasi radiogroup dan radiobutton
				if (rd1.isChecked()) {
					Data_pilihan_jk = rd1.getText().toString();
				}
				if (rd2.isChecked()) {
					Data_pilihan_jk = rd2.getText().toString();
				}
				
//				aktifasi checkbox
				if (cb1.isChecked()) {
					Data_pilihan_item = cb1.getText().toString();
					kondisiHargaTiket = 30000;
				}
				if (cb2.isChecked()) {
					Data_pilihan_item = cb2.getText().toString();
					kondisiHargaTiket = 60000;
				}
				if (cb3.isChecked()) {
					Data_pilihan_item = cb3.getText().toString();
					kondisiHargaTiket = 90000;
				}
				if (cb4.isChecked()) {
					Data_pilihan_item = cb4.getText().toString();
					kondisiHargaTiket = 110000;
				}
				
//				menghitung total harga tiket
				totalBayar = kondisiHargaTiket + biaya_admin;
				
//				keluaran text
				txt_hasil.setText("DATA PESERTA"									+ "\n" +
								  "===============================" 				+ "\n" +
								  "No Registrasi : " 		+ Data_no 				+ "\n" +
								  "Nama : " 				+ Data_nama 			+ "\n" +
								  "Jenis Kelamin : " 		+ Data_pilihan_jk		+ "\n" +
								  "Paket : " 				+ Data_pilihan_item		+ "\n" +
								  "Tanggal Pendaftaran : " 	+ Data_tanggal	 		+ "\n" +
								  "No Telepon : "			+ Data_telepon		 	+ "\n" +
								  "Topik Webinar : " 		+ pilihan_topik 		+ "\n" +
								  "Pembayaran Via : " 		+ pilihan1 				+ "\n" +
								  "===============================" 				+ "\n" +
								  "Harga Per Tiket : " 		+ kondisiHargaTiket 	+ "\n" +
								  "Biaya Admin Bank : " 	+ biaya_admin 			+ "\n" +
								  "===============================" 				+ "\n" +
								  "Total Bayar : " 		+ totalBayar	 			+ "\n" +
						   		  "===============================");
				
//				clear
				edit_no.setText("");
				edit_nama.setText("");
				rg.clearCheck();
				cb1.clearFocus();
				cb2.clearFocus();
				cb3.clearFocus();
				edit_tanggal.setText("");
				edit_telepon.setText("");
			}
		});
	}

//	class isi spinner
	private void isi_spinner1() {
		sp_1 = (Spinner)findViewById(R.id.sp_1);
		List<String> list_jawaban_soal1 = new ArrayList<String>();
		list_jawaban_soal1.add("BRI");
		list_jawaban_soal1.add("BCA");
		list_jawaban_soal1.add("MANDIRI");
		list_jawaban_soal1.add("NAGARI");
		list_jawaban_soal1.add("BTN");
		list_jawaban_soal1.add("BNI");
		list_jawaban_soal1.add("CIMB");
		list_jawaban_soal1.add("BUKOPIN SYARIAH");
		
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
