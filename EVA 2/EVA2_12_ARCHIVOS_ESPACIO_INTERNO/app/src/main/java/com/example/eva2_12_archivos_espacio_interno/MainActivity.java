package com.example.eva2_12_archivos_espacio_interno;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText edtTxtMlDatos;
    final String ARCHIVITO = "archivito.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtMlDatos = findViewById(R.id.edtTxtMlDatos);
    }

    public void guardar(View v) {
        String[] asCade = edtTxtMlDatos.getText().toString().split("\n");

        try {
            OutputStream outputStream = openFileOutput(ARCHIVITO,0);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter =  new BufferedWriter(outputStreamWriter);
            for (int i = 0;i < asCade.length;i++){
                Log.wtf("Datos",asCade[i]);
                bufferedWriter.append(asCade[i]);
                bufferedWriter.append("\n");
            }
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void leer(View v) {
        try {
            InputStream inputStream = openFileInput(ARCHIVITO);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String sCade;
            while ((sCade = bufferedReader.readLine()) != null) {
                edtTxtMlDatos.append(sCade);
                edtTxtMlDatos.append("\n");
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}