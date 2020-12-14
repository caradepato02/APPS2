package com.example.eva_13_archivos_espacio_externo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ActivityOptions;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
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
    String rutaSDApp, rutaSD;
    boolean bLeerEscArchivo =false;
    final static int PERMISO_ESCRITURA = 1;
    final static String ARCHIVO = "prueba.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtMlDatos =  findViewById(R.id.edtTxtMlDatos);
        rutaSD = Environment.getExternalStorageDirectory().getAbsolutePath();
        rutaSDApp = getExternalFilesDir(null).getAbsolutePath();
        Log.wtf("rutaSD",rutaSD);
        Log.wtf("rutaSDApp",rutaSDApp);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){//Version de android
            if(ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISO_ESCRITURA);
            }else{
                bLeerEscArchivo = true;
            }

        }else{
            bLeerEscArchivo = true;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISO_ESCRITURA){
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                bLeerEscArchivo =true;
            }
        }
    }

    public void guardar(View v){
        if(bLeerEscArchivo){
            String[] asCadenas = edtTxtMlDatos.getText().toString().split("\n");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(rutaSDApp + "/" + ARCHIVO);
                OutputStreamWriter outputStreamWriter =  new OutputStreamWriter(fileOutputStream);
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
    }

    public void leer(View v){
        if(bLeerEscArchivo){
            try {
                FileInputStream fileInputStream =  new FileInputStream(rutaSDApp + "/" + ARCHIVO);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
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
}