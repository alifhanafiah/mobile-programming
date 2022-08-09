package com.example.project_3;

import com.example.project_2.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
//	perkenalkan id komponen
	TextView txt_nama;
	Button btn_proses;
	EditText edit_nama;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        deklarasikan id komponen
//        R adalah android
        txt_nama = (TextView)findViewById(R.id.txt_nama);
        btn_proses = (Button)findViewById(R.id.btn_proses);
        edit_nama = (EditText)findViewById(R.id.edit_nama);
        
//        perintah aktifkan button
        btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				segala yang di click nanti ada di sini
//				siapkan 1 variabel dengan tipe data string untuk menampung data nama
				String data_nama = null;
				
//				perintah untuk menampung data nama dari isian input nama
				data_nama = String.valueOf(edit_nama.getText());
				
//				kirim data nama ke komponen id txt_nama
				txt_nama.setText("Nama Saya: " + data_nama);
				edit_nama.setText("");
				
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
