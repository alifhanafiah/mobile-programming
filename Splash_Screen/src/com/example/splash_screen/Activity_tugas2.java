package com.example.splash_screen;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_tugas2 extends Activity {
//	perkenalkan id komponen
	TextView txt_data;
	Button btn_proses, btn_back2;
	EditText edit_tgl, edit_nama, edit_kode, edit_lama;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_tugas2);
//      deklarasikan id komponen
//      R adalah android
        txt_data = (TextView)findViewById(R.id.txt_data);
        btn_proses = (Button)findViewById(R.id.btn_proses);
        edit_tgl = (EditText)findViewById(R.id.edit_tgl);
        edit_nama = (EditText)findViewById(R.id.edit_nama);
        edit_kode = (EditText)findViewById(R.id.edit_kode);
        edit_lama = (EditText)findViewById(R.id.edit_lama);
        
//      perintah aktifkan button
        btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				segala yang di click nanti ada di sini
//				siapkan variabel dengan tipe data string untuk menampung data
				String data_tgl = null,
						data_nama = null,
						data_kode = null;
				int data_lama = 0;
				
				String data_kamar = null,
						data_bed = null,
						data_fasilitas = null,
						data_hidangan = null;
				int data_harga = 0,
					data_potongan = 0,
					data_total = 0;
				
//				perintah untuk menampung data dari isian input
				data_tgl = String.valueOf(edit_tgl.getText());
				data_nama = String.valueOf(edit_nama.getText());
				data_kode = String.valueOf(edit_kode.getText());
				data_lama = Integer.parseInt(edit_lama.getText().toString());
				
//				percabangan pemilihan kamar
				if ("1".equalsIgnoreCase(data_kode)) {
					data_kamar = "Superior";
					data_bed = "Double Bed";
					data_fasilitas = "WIFI";
					data_hidangan = "Breakfast";
					data_harga = 400000;
				} else if ("2".equalsIgnoreCase(data_kode)) {
					data_kamar = "Deluxe";
					data_bed = "Double Bed";
					data_fasilitas = "WIFI";
					data_hidangan = "Breakfast";
					data_harga = 650000;
				} else {
					data_kamar = "President";
					data_bed = "Double Bed";
					data_fasilitas = "WIFI";
					data_hidangan = "Breakfast + Makan Malam";
					data_harga = 2000000;
				} 
				
//				percabangan potongan
				if ((data_lama>=2) && (data_lama<=4)) {
					data_potongan = 100000;
				} else if ((data_lama>=5) && (data_lama<=7)) {
					data_potongan = 200000;
				} else {
					data_potongan = 300000;
				}
				
//				perhitungan
				data_total = data_harga - data_potongan;
				
//				kirim data ke komponen id
				txt_data.setText("====================================" + "\n" +
								 "==========Output Program============" + "\n" +
								 "====================================" + "\n" +
								 "Tgl Transaksi		: " + data_tgl		+ "\n" +
								 "Nama Pengunjung	: " + data_nama		+ "\n" +
								 "Kode Kamar		: " + data_kode		+ "\n" +
								 "Lama Menginap		: " + data_lama		+ "\n" +
								 "====================================" + "\n" +
								 "Kamar				: " + data_kamar	+ "\n" +
								 "Bed				: " + data_bed		+ "\n" +
								 "Fasilitas			: " + data_fasilitas+ "\n" +
								 "Hidangan			: " + data_hidangan	+ "\n" +
								 "Harga				: " + data_harga	+ "\n" +
								 "====================================" + "\n" +
								 "Potongan			: " + data_potongan	+ "\n" +
								 "====================================" + "\n" +
								 "Total				: " + data_total	+ "\n" +
								 "====================================");
				
//				clear
				edit_tgl.setText("");
				edit_nama.setText("");
				edit_kode.setText("");
				edit_lama.setText("");
			}
		});
        
        btn_back2 = (Button)findViewById(R.id.btn_back2);
        btn_back2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent pindahtugas2 = new Intent();
				setResult(RESULT_OK, pindahtugas2);
				finish();
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
