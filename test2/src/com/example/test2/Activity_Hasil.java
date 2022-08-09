package com.example.test2;

import com.example.muhammadalifhanafiah_19101152630021_tugas_1.R;
import com.example.muhammadalifhanafiah_19101152630021_tugas_1.R.layout;
import com.example.muhammadalifhanafiah_19101152630021_tugas_1.R.menu;
import com.example.test2.*;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Hasil extends Activity {

	TextView txt_hasil;
	Button btn_back;
	
	Intent pindah = new Intent();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity__hasil);
		
		txt_hasil = (TextView)findViewById(R.id.txt_hasil);
		
		String data_kamar = null,
				data_bed = null,
				data_fasilitas = null,
				data_hidangan = null;
		
		int data_harga = 0,
			data_potongan = 0,
			data_total = 0;
		
//		1. alert dialog untuk validasi data kirim
		AlertDialog.Builder validasi_data = new AlertDialog.Builder(Activity_Hasil.this);
		validasi_data.setTitle("Verifikasi Data Hasil Input");
		validasi_data.setMessage("Sukses Entry Data");
		validasi_data.setNegativeButton("OK", null);
		validasi_data.show();
		
//		2. proses penerima data yang sudah di parsing dari form sebelumnya
		pindah = getIntent();
		
//		3. siapkan variabel penampung data kiriman
		String Data_Tampung_Tgl = null, Data_Tampung_Nama = null, Data_Tampung_Kode = null;
		int Data_Tampung_Lama = 0;
		
//		4. buatkan perintah tampung data kiriman
		Data_Tampung_Tgl  = pindah.getStringExtra("data_tgl");
		Data_Tampung_Nama = pindah.getStringExtra("data_nama");
		Data_Tampung_Kode = pindah.getStringExtra("data_kode");
		Data_Tampung_Lama = pindah.getIntExtra("data_lama", 0);
		
//		proses
//		percabangan pemilihan kamar
		if ("1".equalsIgnoreCase(Data_Tampung_Kode)) {
			data_kamar = "Superior";
			data_bed = "Double Bed";
			data_fasilitas = "WIFI";
			data_hidangan = "Breakfast";
			data_harga = 400000;
		} else if ("2".equalsIgnoreCase(Data_Tampung_Kode)) {
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
		
//		percabangan potongan
		if ((Data_Tampung_Lama>=2) && (Data_Tampung_Lama<=4)) {
			data_potongan = 100000;
		} else if ((Data_Tampung_Lama>=5) && (Data_Tampung_Lama<=7)) {
			data_potongan = 200000;
		} else {
			data_potongan = 300000;
		}
		
//		perhitungan
		data_total = data_harga - data_potongan;
		
//		kirim data ke komponen id
		txt_hasil.setText("====================================" + "\n" +
						 "==========Output Program============" + "\n" +
						 "====================================" + "\n" +
						 "Tgl Transaksi		: " + Data_Tampung_Tgl		+ "\n" +
						 "Nama Pengunjung	: " + Data_Tampung_Nama		+ "\n" +
						 "Kode Kamar		: " + Data_Tampung_Kode		+ "\n" +
						 "Lama Menginap		: " + Data_Tampung_Lama		+ "\n" +
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
		
		btn_back = (Button)findViewById(R.id.btn_back);
		btn_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				setResult(RESULT_OK, pindah);
				finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__hasil, menu);
		return true;
	}

}
