package com.example.project_2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
//	perkenalkan id komponen
	TextView txt_nama;
	Button btn_proses;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        deklarasikan id komponen
//        R adalah android
        txt_nama = (TextView)findViewById(R.id.txt_nama);
        btn_proses = (Button)findViewById(R.id.btn_proses);
        
//        perintah aktifkan button
        btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				segala yang di click nanti ada di sini
//				siapkan 1 variabel dengan tipe data string untuk menampung data nama
				String data_nama = "Budi";
				
//				kirim data nama ke komponen id txt_nama
				txt_nama.setText("Nama Saya: " + data_nama);
				
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
