package com.example.muhammadalifhanafiah_19101152630021;

import com.example.alif_tab.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Activity_utama extends Activity {
//	perkenalkan id
Button btn_tugas1, btn_tugas2, btn_tugas3, btn_tugas4, btn_tugas5, btn_tugas6, btn_kembali;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_utama);
		
		// tugas 1
		btn_tugas1 = (Button)findViewById(R.id.btn_tugas1);
		btn_tugas1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			// buatkan perintah intent untuk perpindahan layout
				Intent pindahtugas1 = new Intent(arg0.getContext(), Activity_tugas1.class);
				startActivityForResult(pindahtugas1, 1);
				
			}
		});
		// tugas 2
		btn_tugas2 = (Button)findViewById(R.id.btn_tugas2);
		btn_tugas2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			// buatkan perintah intent untuk perpindahan layout
				Intent pindahtugas2 = new Intent(arg0.getContext(), Activity_tugas2.class);
				startActivityForResult(pindahtugas2, 1);
				
			}
		});
		// tugas 3
		btn_tugas3 = (Button)findViewById(R.id.btn_tugas3);
		btn_tugas3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			// buatkan perintah intent untuk perpindahan layout
				Intent pindahtugas3 = new Intent(arg0.getContext(), Activity_tugas3.class);
				startActivityForResult(pindahtugas3, 1);
				
			}
		});
		// tugas 4
		btn_tugas4 = (Button)findViewById(R.id.btn_tugas4);
		btn_tugas4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			// buatkan perintah intent untuk perpindahan layout
				Intent pindahtugas4 = new Intent(arg0.getContext(), Activity_tugas4.class);
				startActivityForResult(pindahtugas4, 1);
				
			}
		});
		// tugas 5
		btn_tugas5 = (Button)findViewById(R.id.btn_tugas5);
		btn_tugas5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			// buatkan perintah intent untuk perpindahan layout
				Intent pindahtugas5 = new Intent(arg0.getContext(), Activity_tugas5.class);
				startActivityForResult(pindahtugas5, 1);
				
			}
		});
		// tugas 6
		btn_tugas6 = (Button)findViewById(R.id.btn_tugas6);
		btn_tugas6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			// buatkan perintah intent untuk perpindahan layout
				Intent pindahtugas6 = new Intent(arg0.getContext(), Activity_tugas6.class);
				startActivityForResult(pindahtugas6, 1);
				
			}
		});
		
		btn_kembali = (Button)findViewById(R.id.btn_kembali);
		btn_kembali.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent pindahtugaskuliah = new Intent();
				setResult(RESULT_OK, pindahtugaskuliah);
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
