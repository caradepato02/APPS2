package com.example.eva2_14_document_provider;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText edtTxtMlDatos;
    final int ABRIR_ARCHIVO = 100;
    final int GUARDAR_ARCHIVO = 200;

    Uri uriResu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtMlDatos =  findViewById(R.id.edtTxtMlDatos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case ABRIR_ARCHIVO:
                if(resultCode == Activity.RESULT_OK){
                    uriResu = data.getData();
                    Log.wtf("URI",data.getData().toString());
                    try {
                        InputStream inputStream =  getContentResolver().openInputStream(uriResu);
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String sCade;
                        edtTxtMlDatos.setText("");
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
                break;
            case GUARDAR_ARCHIVO:
                if(resultCode == Activity.RESULT_OK){
                    uriResu = data.getData();
                    Log.wtf("URI",data.getData().toString());
                    String[] asCadenas = edtTxtMlDatos.getText().toString().split("\n");
                    try {
                        OutputStream outputStream = getContentResolver().openOutputStream(uriResu);
                        OutputStreamWriter outputStreamWriter =  new OutputStreamWriter(outputStream);
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                        for (int i = 0;i < asCadenas.length;i++){
                            Log.wtf("Datos",asCadenas[i]);
                            bufferedWriter.append(asCadenas[i]);
                            bufferedWriter.append("\n");
                        }
                        bufferedWriter.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public void abrir(View v){
        Intent inAbrir =  new Intent(Intent.ACTION_OPEN_DOCUMENT);
        inAbrir.addCategory(Intent.CATEGORY_OPENABLE);
        inAbrir.setType("text/plain");//MIME
        inAbrir.putExtra(Intent.EXTRA_TITLE,"prueba.txt");
        inAbrir.putExtra(DocumentsContract.EXTRA_INITIAL_URI,uriResu);//opcional
        startActivityForResult(inAbrir,ABRIR_ARCHIVO);
    }

    public void guardar(View v){
        Intent inGuardar =  new Intent(Intent.ACTION_CREATE_DOCUMENT);
        inGuardar.addCategory(Intent.CATEGORY_OPENABLE);
        inGuardar.setType("text/plain");//MIME
        inGuardar.putExtra(Intent.EXTRA_TITLE,"prueba.txt");
        inGuardar.putExtra(DocumentsContract.EXTRA_INITIAL_URI,uriResu);//opcional
        startActivityForResult(inGuardar,GUARDAR_ARCHIVO);
    }
}