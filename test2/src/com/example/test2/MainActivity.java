package com.example.test2;

import com.example.muhammadalifhanafiah_19101152630021_tugas_1.R;
import com.example.test2.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
//	perkenalkan id komponen
	Button btn_proses;
	EditText edit_tgl, edit_nama, edit_kode, edit_lama;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//      deklarasikan id komponen
//      R adalah android
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
				
//				perintah untuk menampung data dari isian input
				data_tgl = String.valueOf(edit_tgl.getText());
				data_nama = String.valueOf(edit_nama.getText());
				data_kode = String.valueOf(edit_kode.getText());
				data_lama = Integer.parseInt(edit_lama.getText().toString());
				
				Intent pindah = new Intent(getApplicationContext(), Activity_Hasil.class);
				
//				parsing data dimulai dengan memperkenalkan variabel kiri pada setiap data yang ada
//				variabel kirim juga akan terhubung langsung dengan intent (pindah)
				pindah.putExtra("data_tgl", data_tgl);
				pindah.putExtra("data_nama", data_nama);
				pindah.putExtra("data_kode", data_kode);
				pindah.putExtra("data_lama", data_lama);
				startActivity(pindah);
				
//				clear
				edit_tgl.setText("");
				edit_nama.setText("");
				edit_kode.setText("");
				edit_lama.setText("");
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
