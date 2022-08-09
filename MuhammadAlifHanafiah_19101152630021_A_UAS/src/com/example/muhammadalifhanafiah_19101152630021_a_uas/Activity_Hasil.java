package com.example.muhammadalifhanafiah_19101152630021_a_uas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Hasil extends Activity {

	TextView hasil_reg, hasil_tipe, hasil_nama, hasil_aktifitas, hasil_lama;
	Button btn_back;
	
	Intent pindah = new Intent();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity__hasil);
		
		hasil_reg = (TextView)findViewById(R.id.hasil_reg);
		hasil_tipe = (TextView)findViewById(R.id.hasil_tipe);
		hasil_nama = (TextView)findViewById(R.id.hasil_nama);
		hasil_aktifitas = (TextView)findViewById(R.id.hasil_aktifitas);
		hasil_lama = (TextView)findViewById(R.id.hasil_lama);
		
//		2. proses penerima data yang sudah di parsing dari form sebelumnya
		pindah = getIntent();
		
//		3. siapkan variabel penampung data kiriman
		String Data_Tampung_hasilreg = null;
		String Data_Tampung_hasiltipe = null;
		String Data_Tampung_hasilnama = null;
		String Data_Tampung_hasilaktifitas = null;
		String Data_Tampung_hasillama = null;
		
//		4. buatkan perintah tampung data kiriman
		Data_Tampung_hasilreg = pindah.getStringExtra("data_reg");
		Data_Tampung_hasiltipe = pindah.getStringExtra("data_tipe");
		Data_Tampung_hasilnama = pindah.getStringExtra("data_nama");
		Data_Tampung_hasilaktifitas = pindah.getStringExtra("data_aktifitas");
		Data_Tampung_hasillama = pindah.getStringExtra("data_lama");
		
//		5. buatkan perintah untuk tampil data kiriman
		hasil_reg.setText("No Registasi:" + Data_Tampung_hasilreg);
		hasil_tipe.setText("Tipe Pengunjung:" + Data_Tampung_hasiltipe);
		hasil_nama.setText("Nama Pengunjung:" + Data_Tampung_hasilnama);
		hasil_aktifitas.setText("Aktifitas Pengunjung:" + Data_Tampung_hasilaktifitas);
		hasil_lama.setText("Lama Kunjungan:" + Data_Tampung_hasillama);
		
//		6. aktifkan tombol back
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
