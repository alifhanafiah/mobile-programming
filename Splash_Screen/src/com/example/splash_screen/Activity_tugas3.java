package com.example.splash_screen;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_tugas3 extends Activity {
//	perkenalkan id komponen
	TextView txt_data;
	Button btn_proses, btn_back3;
	EditText edit_nama, edit_tipe, edit_kendala, edit_sparepart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_tugas3);
//      deklarasikan id komponen
//      R adalah android
        txt_data = (TextView)findViewById(R.id.txt_data);
        btn_proses = (Button)findViewById(R.id.btn_proses);
        edit_nama = (EditText)findViewById(R.id.edit_nama);
        edit_tipe = (EditText)findViewById(R.id.edit_tipe);
        edit_kendala = (EditText)findViewById(R.id.edit_kendala);
        edit_sparepart = (EditText)findViewById(R.id.edit_sparepart);
        
//      perintah aktifkan button
        btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				segala yang di click nanti ada di sini
//				siapkan variabel dengan tipe data string untuk menampung data
				String data_nama = null,
						data_tipe = null,
						data_kendala = null,
						data_sparepart = null;
				int harga_jasa = 0,
					harga_barang = 0,
					harga_total = 0;
				
//				perintah untuk menampung data dari isian input
				data_nama = String.valueOf(edit_nama.getText());
				data_tipe = String.valueOf(edit_tipe.getText());
				data_kendala = String.valueOf(edit_kendala.getText());
				data_sparepart = String.valueOf(edit_sparepart.getText());
				
//				percabangan harga jasa service
				if (("otomatis".equalsIgnoreCase(data_tipe)) && ("mesin".equalsIgnoreCase(data_kendala))) {
					harga_jasa = 750000;
				} else {
					harga_jasa = 550000;
				}

				
//				percabangan harga barang
				if ("busi".equalsIgnoreCase(data_sparepart)) {
					harga_barang = 150000;
				} else if ("oli".equalsIgnoreCase(data_sparepart)) {
					harga_barang = 100000;
				} else {
					harga_barang = 450000;
				}
				
//				perhitungan
				harga_total = harga_jasa + harga_barang;
				
//				kirim data ke komponen id
				txt_data.setText("====================================" + "\n" +
								 "==========Output Program============" + "\n" +
								 "====================================" + "\n" +
								 "Nama Pemilik		: " + data_nama		+ "\n" +
								 "Tipe Kendaraan	: " + data_tipe		+ "\n" +
								 "Kendala			: " + data_kendala	+ "\n" +
								 "Sparepart			: " + data_sparepart+ "\n" +
								 "====================================" + "\n" +
								 "Harga Jasa		: " + harga_jasa	+ "\n" +
								 "Harga Barang		: " + harga_barang	+ "\n" +
								 "====================================" + "\n" +
								 "Total Harga		: " + harga_total	+ "\n" +
								 "====================================");
				
//				clear
				edit_nama.setText("");
				edit_tipe.setText("");
				edit_kendala.setText("");
				edit_sparepart.setText("");
			}
		});
        
        btn_back3 = (Button)findViewById(R.id.btn_back3);
        btn_back3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent pindahtugas3 = new Intent();
				setResult(RESULT_OK, pindahtugas3);
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
