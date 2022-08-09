package com.example.splash_screen;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_tugas1 extends Activity {
//	perkenalkan id komponen
	TextView txt_data;
	Button btn_proses, btn_back;
	EditText edit_tgl, edit_nama, edit_tujuan, edit_paket, edit_jenis;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_tugas1);
//      deklarasikan id komponen
//      R adalah android
        txt_data = (TextView)findViewById(R.id.txt_data);
        btn_proses = (Button)findViewById(R.id.btn_proses);
        edit_tgl = (EditText)findViewById(R.id.edit_tgl);
        edit_nama = (EditText)findViewById(R.id.edit_nama);
        edit_tujuan = (EditText)findViewById(R.id.edit_tujuan);
        edit_paket = (EditText)findViewById(R.id.edit_paket);
        edit_jenis = (EditText)findViewById(R.id.edit_jenis);
        
//      perintah aktifkan button
        btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				segala yang di click nanti ada di sini
//				siapkan variabel dengan tipe data string untuk menampung data
				String data_tgl = null,
						data_nama = null,
						data_tujuan = null,
						data_paket = null,
						data_jenis = null;
				int data_harga = 0;
				
//				perintah untuk menampung data dari isian input
				data_tgl = String.valueOf(edit_tgl.getText());
				data_nama = String.valueOf(edit_nama.getText());
				data_tujuan = String.valueOf(edit_tujuan.getText());
				data_paket = String.valueOf(edit_paket.getText());
				data_jenis = String.valueOf(edit_jenis.getText());
				
//				percabangan
				if (("normal".equalsIgnoreCase(data_paket)) && ("documen".equalsIgnoreCase(data_jenis))) {
					data_harga = 15000;
				} else if (("express".equalsIgnoreCase(data_paket)) && ("documen".equalsIgnoreCase(data_jenis))) {
					data_harga = 20000;
				} else if (("normal".equalsIgnoreCase(data_paket)) && ("bingkisan".equalsIgnoreCase(data_jenis))) {
					data_harga = 20000;
				} else {
					data_harga = 25000;
				}
				
//				kirim data ke komponen id
				txt_data.setText("====================================" + "\n" +
								 "==========Output Program============" + "\n" +
								 "====================================" + "\n" +
								 "Tgl Pengiriman	: " + data_tgl		+ "\n" +
								 "Nama Pengirim		: " + data_nama		+ "\n" +
								 "Tujuan			: " + data_tujuan	+ "\n" +
								 "Paket Pengiriman	: " + data_paket	+ "\n" +
								 "Jenis Barang		: " + data_jenis	+ "\n" +
								 "====================================" + "\n" +
								 "Harga Per Kilo	: " + data_harga	+ "\n" +
								 "====================================");
				
//				clear
				edit_tgl.setText("");
				edit_nama.setText("");
				edit_tujuan.setText("");
				edit_paket.setText("");
				edit_jenis.setText("");
			}
		});
        
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent pindahtugas1 = new Intent();
				setResult(RESULT_OK, pindahtugas1);
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
