package com.example.project_4;

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
	TextView txt_data;
	Button btn_proses;
	EditText edit_nobp;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        deklarasikan id komponen
//        R adalah android
        txt_data = (TextView)findViewById(R.id.txt_data);
        btn_proses = (Button)findViewById(R.id.btn_proses);
        edit_nobp = (EditText)findViewById(R.id.edit_nobp);
        
//        perintah aktifkan button
        btn_proses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				segala yang di click nanti ada di sini
//				siapkan variabel dengan tipe data string untuk menampung data
				String data_nobp = null,
						data_nama = null,
						data_kls = null,
						data_jur = null;
				
//				perintah untuk menampung data dari isian input
				data_nobp = String.valueOf(edit_nobp.getText());
				
				////////////////////////////////////////////////
//				percabangan tunggal
				if ("190001".equalsIgnoreCase(data_nobp)) {
					data_nama = "Budi";
					data_kls = "IF - 2";
					data_jur = "Teknik Informatika";
				} else if ("190002".equalsIgnoreCase(data_nobp)) {
					data_nama = "Alif";
					data_kls = "IF - 1";
					data_jur = "Teknik Informatika";
				} else {
					data_nobp = "Data Tidak Ditemukan";
					data_nama = "Data Tidak Ditemukan";
					data_kls = "Data Tidak Ditemukan";
					data_jur = "Data Tidak Ditemukan";
				}
				
//				kirim data ke komponen id
				txt_data.setText("====================================" + "\n" +
								 "==========Output Program============" + "\n" +
								 "====================================" + "\n" +
								 "Nobp		:" + data_nobp				+ "\n" +
								 "Nama		:" + data_nama				+ "\n" +
								 "Kelas		:" + data_kls				+ "\n" +
								 "Jurusan	:" + data_jur				+ "\n" +
								 "====================================");
				
//				clear
				edit_nobp.setText("");
				
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
