package com.example.tiket;

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
import android.widget.TextView;

public class MainActivity extends Activity {

//	kenalkan semua komponen yang memiliki id
	EditText edit_kode, edit_nama, edit_tgl, edit_jmlPen;
	RadioGroup rg;
	RadioButton rd1, rd2;
	CheckBox cb1, cb2, cb3;
	ListView ls;
	Button btn_proses;
	TextView txt_hasil;
	
//	variabel untuk edit id dan nama
	String Data_kode, Data_nama, Data_tgl = null;
	int Data_jmlPen, kondisiHargaTiket, totalBayar = 0;
	String Data_pilihan_studio = null;
	String Data_pilihan_bioskop = null;
	
//	isian dari list
	String [] daftar_film = {"SPIDER-MAN: NO WAY HOME",
							 "THE BATMAN",
							 "JUJUTSU KAISEN 0",
							 "MORBIUS",
							 "DOCTOR STRANGE",
							 "KKN DI DESA PENARI"};
	String pilihan_film = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		deklarasikan
		edit_kode = (EditText)findViewById(R.id.edit_kode);
		edit_nama = (EditText)findViewById(R.id.edit_nama);
		edit_tgl = (EditText)findViewById(R.id.edit_tgl);
		edit_jmlPen = (EditText)findViewById(R.id.edit_jmlPen);
		rg = (RadioGroup)findViewById(R.id.rg);
		rd1 = (RadioButton)findViewById(R.id.rd1);
		rd2 = (RadioButton)findViewById(R.id.rd2);
		cb1 = (CheckBox)findViewById(R.id.cb1);
		cb2 = (CheckBox)findViewById(R.id.cb2);
		cb3 = (CheckBox)findViewById(R.id.cb3);
		ls = (ListView)findViewById(R.id.ls);
		btn_proses = (Button)findViewById(R.id.btn_proses);
		txt_hasil = (TextView)findViewById(R.id.txt_hasil);
		
		
//		adapter list (penghubung isian dengan design list)
		ArrayAdapter<String> konektor_list = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, daftar_film);
		ls.setAdapter(konektor_list);
		
//		proses dari list
		ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
//				aktifkan tampung data id dan nama
				Data_kode = String.valueOf(edit_kode.getText().toString());
				Data_nama = String.valueOf(edit_nama.getText().toString());
				Data_tgl = String.valueOf(edit_tgl.getText().toString());
				Data_jmlPen = Integer.parseInt(edit_jmlPen.getText().toString());
				
//				aktivasi radiogroup dan radiobutton
				if (rd1.isChecked()) {
					Data_pilihan_studio = rd1.getText().toString();
					kondisiHargaTiket = 30000;
				}
				if (rd2.isChecked()) {
					Data_pilihan_studio = rd2.getText().toString();
					kondisiHargaTiket = 50000;
				}
				
//				aktifasi checkbox
				if (cb1.isChecked()) {
					Data_pilihan_bioskop = cb1.getText().toString();
				}
				if (cb2.isChecked()) {
					Data_pilihan_bioskop = cb2.getText().toString();
				}
				if (cb3.isChecked()) {
					Data_pilihan_bioskop = cb3.getText().toString();
				}
				
				pilihan_film = String.valueOf(daftar_film[position]);
				
//				buatkan validasi pilihan
				AlertDialog.Builder validasi_pilihan_film = new AlertDialog.Builder(MainActivity.this);
				validasi_pilihan_film.setTitle("Validasi data pilihan");
				validasi_pilihan_film.setMessage("Kode Booking : " 		+ Data_kode 				+ "\n" +
												 "Nama : " 				+ Data_nama 				+ "\n" +
												 "Jenis Studio : " 		+ Data_pilihan_studio		+ "\n" +
												 "Bioskop : " 			+ Data_pilihan_bioskop		+ "\n" +
												 "Tanggal Tayang : "	+ Data_tgl		 			+ "\n" +
												 "Jumlah Penonton : " 	+ Data_jmlPen	 			+ "\n" +
												 "Film : " 				+ pilihan_film 				+ "\n" +
												 "================================="			+ "\n" +
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
//				aktifkan tampung data id dan nama
				Data_kode = String.valueOf(edit_kode.getText().toString());
				Data_nama = String.valueOf(edit_nama.getText().toString());
				
//				aktivasi radiogroup dan radiobutton
				if (rd1.isChecked()) {
					Data_pilihan_studio = rd1.getText().toString();
					kondisiHargaTiket = 30000;
				}
				if (rd2.isChecked()) {
					Data_pilihan_studio = rd2.getText().toString();
					kondisiHargaTiket = 50000;
				}
				
//				aktifasi checkbox
				if (cb1.isChecked()) {
					Data_pilihan_bioskop = cb1.getText().toString();
				}
				if (cb2.isChecked()) {
					Data_pilihan_bioskop = cb2.getText().toString();
				}
				if (cb3.isChecked()) {
					Data_pilihan_bioskop = cb3.getText().toString();
				}
				
//				menghitung total harga tiket
				totalBayar = kondisiHargaTiket * Data_jmlPen;
				
//				keluaran text
				txt_hasil.setText("DATA TIKET"										+ "\n" +
								  "===============================" 				+ "\n" +
								  "Kode Booking : " 	+ Data_kode 				+ "\n" +
								  "Nama : " 			+ Data_nama 				+ "\n" +
								  "Jenis Studio : " 	+ Data_pilihan_studio		+ "\n" +
								  "Bioskop : " 			+ Data_pilihan_bioskop		+ "\n" +
								  "Tanggal Tayang : "	+ Data_tgl		 			+ "\n" +
								  "Jumlah Penonton : " 	+ Data_jmlPen	 			+ "\n" +
								  "Film : " 			+ pilihan_film 				+ "\n" +
								  "===============================" 				+ "\n" +
								  "Harga Per Kursi : " 	+ kondisiHargaTiket 		+ "\n" +
								  "Total Bayar : " 		+ totalBayar	 			+ "\n" +
						   		  "===============================");
				
//				clear
				edit_kode.setText("");
				edit_nama.setText("");
				rg.clearCheck();
				cb1.clearFocus();
				cb2.clearFocus();
				cb3.clearFocus();
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
