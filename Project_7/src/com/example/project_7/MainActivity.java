package com.example.project_7;

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
	EditText edit_id, edit_nama, edit_tgl, edit_jmlPen;
	RadioGroup rg;
	RadioButton rd1, rd2;
	CheckBox cb1, cb2, cb3;
	ListView ls;
	Button btn_proses;
	TextView txt_hasil;
	
//	variabel untuk edit id dan nama
	String Data_identitas, Data_nama, Data_tgl = null;
	int Data_jmlPen, totalBayar = 0;
	int kondisiHargaTiket = 120000; 
	String Data_pilihan_jk = null;
	String Data_pilihan_asal = null;
	
//	isian dari list
	String [] daftar_tujuan = {"Jakarta",
								"Bandung",
								"Surabaya",
								"Medan",
								"Bali"};
	String pilihan_tujuan = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		deklarasikan
		edit_id = (EditText)findViewById(R.id.edit_id);
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
				android.R.layout.simple_list_item_1, daftar_tujuan);
		ls.setAdapter(konektor_list);
		
//		proses dari list
		ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
//				aktifkan tampung data id dan nama
				Data_identitas = String.valueOf(edit_id.getText().toString());
				Data_nama = String.valueOf(edit_nama.getText().toString());
				Data_tgl = String.valueOf(edit_tgl.getText().toString());
				Data_jmlPen = Integer.parseInt(edit_jmlPen.getText().toString());
				
//				aktivasi radiogroup dan radiobutton
				if (rd1.isChecked()) {
					Data_pilihan_jk = rd1.getText().toString();
				}
				if (rd2.isChecked()) {
					Data_pilihan_jk = rd2.getText().toString();
				}
				
//				aktifasi checkbox
				if (cb1.isChecked()) {
					Data_pilihan_asal = cb1.getText().toString();
				}
				if (cb2.isChecked()) {
					Data_pilihan_asal = cb2.getText().toString();
				}
				if (cb3.isChecked()) {
					Data_pilihan_asal = cb3.getText().toString();
				}
				
				pilihan_tujuan = String.valueOf(daftar_tujuan[position]);
				
//				buatkan validasi pilihan
				AlertDialog.Builder validasi_pilihan_tujuan = new AlertDialog.Builder(MainActivity.this);
				validasi_pilihan_tujuan.setTitle("Validasi data pilihan");
				validasi_pilihan_tujuan.setMessage("ID : " 					+ Data_identitas 	+ "\n" +
												   "Nama : " 				+ Data_nama 		+ "\n" +
												   "Jk : "  				+ Data_pilihan_jk 	+ "\n" +
												   "Asal : " 				+ Data_pilihan_asal + "\n" +
												   "Tgl Keberangkatan : " 	+ Data_tgl		 	+ "\n" +
												   "Jml Penumpang : " 		+ Data_jmlPen	 	+ "\n" +
												   "Tujuan : " 				+ pilihan_tujuan 	+ "\n" +
												   "==============================="			+ "\n" +
												   "apakah data pilihan di atas sudah benar?");
				validasi_pilihan_tujuan.setNeutralButton("OKE", null);
				validasi_pilihan_tujuan.show();
			}
			
		});
		
/////////////////////////////////////////////////////////////////////////////////////////////
		
//		aktifkan button
		btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				aktifkan tampung data id dan nama
				Data_identitas = String.valueOf(edit_id.getText().toString());
				Data_nama = String.valueOf(edit_nama.getText().toString());
				
//				aktivasi radiogroup dan radiobutton
				if (rd1.isChecked()) {
					Data_pilihan_jk = rd1.getText().toString();
				}
				if (rd2.isChecked()) {
					Data_pilihan_jk = rd2.getText().toString();
				}
				
//				aktifasi checkbox
				if (cb1.isChecked()) {
					Data_pilihan_asal = cb1.getText().toString();
				}
				if (cb2.isChecked()) {
					Data_pilihan_asal = cb2.getText().toString();
				}
				if (cb3.isChecked()) {
					Data_pilihan_asal = cb3.getText().toString();
				}
				
//				menghitung total harga tiket
				totalBayar = kondisiHargaTiket * Data_jmlPen;
				
//				keluaran text
				txt_hasil.setText("DATA TIKET"									+ "\n" +
								  "===============================" 			+ "\n" +
								  "ID : " 					+ Data_identitas 	+ "\n" +
								  "Nama : " 				+ Data_nama 		+ "\n" +
								  "Jk : "  					+ Data_pilihan_jk 	+ "\n" +
								  "Asal : " 				+ Data_pilihan_asal + "\n" +
								  "Tgl Keberangkatan : " 	+ Data_tgl		 	+ "\n" +
								  "Jml Penumpang : " 		+ Data_jmlPen	 	+ "\n" +
								  "Tujuan : " 				+ pilihan_tujuan 	+ "\n" +
								  "===============================" 			+ "\n" +
								  "Kondisi Harga Tiket : " 	+ kondisiHargaTiket + "\n" +
								  "Total Bayar : " 			+ totalBayar	 	+ "\n" +
						   		  "===============================");
				
//				clear
				edit_id.setText("");
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
