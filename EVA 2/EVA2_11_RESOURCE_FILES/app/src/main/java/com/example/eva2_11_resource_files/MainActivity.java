package com.example.eva2_11_resource_files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    TextView txtVwArchivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwArchivo = findViewById(R.id.txtVwArchivo);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //Abrir
        //Leer
        //Interpretar
        InputStream inputStream = getResources().openRawResource(R.raw.loremp_ipsum);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String sCade;
        try {
            while((sCade = bufferedReader.readLine()) != null){
                txtVwArchivo.append(sCade);
                txtVwArchivo.append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}