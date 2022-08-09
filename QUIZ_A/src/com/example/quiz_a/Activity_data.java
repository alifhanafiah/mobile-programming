package com.example.quiz_a;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_data extends Activity {
	
	TextView txt_penerima_data;
	Button btn_back;
	
	Intent pindah = new Intent();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_data);
		
		txt_penerima_data = (TextView)findViewById(R.id.txt_penerima_data);
		
//		1. alert dialog untuk validasi data kirim
		AlertDialog.Builder validasi_data = new AlertDialog.Builder(Activity_data.this);
		validasi_data.setTitle("Verifikasi Data Hasil Input");
		validasi_data.setMessage("Sukses Entry Data");
		validasi_data.setNegativeButton("OK", null);
		validasi_data.show();
		
//		2. proses penerima data yang sudah di parsing dari form sebelumnya
		pindah = getIntent();
		
//		3. siapkan variabel penampung data kiriman
		String Data_Tampung_jawaban = null;
		
//		4. buatkan perintah tampung data kiriman
		Data_Tampung_jawaban = pindah.getStringExtra("data_jawaban");
		
//		5. buatkan perintah untuk tampil data kiriman
		txt_penerima_data.setText("Keterangan Hasil Input Data:" 	+ "\n" +
								  "" 								+ "\n" +
								  "============================" 	+ "\n" +
								  "" 								+ "\n" +
								  "JAWABAN YANG ANDA MASUKKAN"		+ "\n" +
								  Data_Tampung_jawaban  			+ "\n" +
								  "" 								+ "\n" +
								  "============================");
		
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
		getMenuInflater().inflate(R.menu.activity_data, menu);
		return true;
	}

}
