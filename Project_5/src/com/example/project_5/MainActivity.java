package com.example.project_5;

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
	EditText edit_nobp, edit_nilai;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        deklarasikan id komponen
//        R adalah android
        txt_data = (TextView)findViewById(R.id.txt_data);
        btn_proses = (Button)findViewById(R.id.btn_proses);
        edit_nobp = (EditText)findViewById(R.id.edit_nobp);
        edit_nilai = (EditText)findViewById(R.id.edit_nilai);
        
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
				int data_nilai = 0;
				String data_huruf = null,
						data_ket = null;
				
//				perintah untuk menampung data dari isian input
				data_nobp = String.valueOf(edit_nobp.getText());
				data_nilai = Integer.parseInt(edit_nilai.getText().toString());
				
				////////////////////////////////////////////////				
//				percabangan bertingkat
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
				
//				percabangan majemuk
				if ((data_nilai>=80) && (data_nilai<=100)) {
					data_huruf = "A";
				} else if ((data_nilai>=65) && (data_nilai<=79)) {
					data_huruf = "B";
				} else if ((data_nilai>=55) && (data_nilai<=64)) {
					data_huruf = "C";
				} else if ((data_nilai>=40) && (data_nilai<=54)) {
					data_huruf = "D";
				} else {
					data_huruf = "E";
				}
				
//				percabangan tunggal
				if ("A".equalsIgnoreCase(data_huruf)) {
					data_ket="LULUS";
				} else {
					data_ket="TIDAK LULUS";
				}
				
//				kirim data ke komponen id
				txt_data.setText("====================================" + "\n" +
								 "==========Output Program============" + "\n" +
								 "====================================" + "\n" +
								 "Nobp		:" + data_nobp				+ "\n" +
								 "Nama		:" + data_nama				+ "\n" +
								 "Kelas		:" + data_kls				+ "\n" +
								 "Jurusan	:" + data_jur				+ "\n" +
								 "====================================" + "\n" +
								 "Nilai		:" + data_nilai				+ "\n" +
								 "Huruf		:" + data_huruf				+ "\n" +
								 "Keterangan:" + data_ket				+ "\n" +
								 "====================================");
				
//				clear
				edit_nobp.setText("");
				edit_nilai.setText("");
				
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
