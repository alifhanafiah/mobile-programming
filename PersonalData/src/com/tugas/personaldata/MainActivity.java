package com.tugas.personaldata;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
//	perkenalkan id komponen
	TextView txt_hasil;
	Button btn_proses;
	Button btn_clear;
	EditText edit_nama;
	EditText edit_daerah;
	EditText edit_makananFavorit;
	EditText edit_hobby;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		deklarasi id komponen
		txt_hasil = (TextView)findViewById(R.id.txt_hasil);
		btn_proses = (Button)findViewById(R.id.btn_proses);
		edit_nama = (EditText)findViewById(R.id.edit_nama);
		edit_daerah = (EditText)findViewById(R.id.edit_daerah);
		edit_makananFavorit = (EditText)findViewById(R.id.edit_makananFavorit);
		edit_hobby = (EditText)findViewById(R.id.edit_hobby);
		
//		perintah untuk mengaktifkan button
		btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				siapkan variabel untuk menampung data
				String data_nama = null;
				String data_daerah = null;
				String data_makananFavorit = null;
				String data_hobby = null;
				
//				perintah untuk menampung data dari input
				data_nama = String.valueOf(edit_nama.getText());
				data_daerah = String.valueOf(edit_daerah.getText());
				data_makananFavorit = String.valueOf(edit_makananFavorit.getText());
				data_hobby = String.valueOf(edit_hobby.getText());
				
//				kirim data ke komponen id
				txt_hasil.setText("Hi semuanya. Nama saya " + data_nama + ". Saya asli dari " + data_daerah + ". Makanan kesukaan saya adalah " + data_makananFavorit + " dan saya suka " + data_hobby + ".");
				edit_nama.setText("");
				edit_daerah.setText("");
				edit_makananFavorit.setText("");
				edit_hobby.setText("");
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
