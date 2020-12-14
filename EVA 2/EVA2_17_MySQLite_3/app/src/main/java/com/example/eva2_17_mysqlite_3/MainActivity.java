package com.example.eva2_17_mysqlite_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lstDatos;
    SQLiteDatabase sqLiteDatabase;
    final String NOMBRE_DB = "mi_base_datos";
    List<String> nombre = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstDatos = findViewById(R.id.lstDatos);
        sqLiteDatabase = openOrCreateDatabase(NOMBRE_DB, MODE_PRIVATE, null);
        try {
            sqLiteDatabase.execSQL("create table prueba(id integer primary key autoincrement," +
                    "nombre text," +
                    "apellido text);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //INSERT
        ContentValues cvDatos = new ContentValues();
        cvDatos.put("nombre","Rodrigo");
        cvDatos.put("apellido","Reyes");
        sqLiteDatabase.insert("prueba",null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre","Alondra");
        cvDatos.put("apellido","Ruiz");
        sqLiteDatabase.insert("prueba",null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre","Luis");
        cvDatos.put("apellido","Anchondo");
        sqLiteDatabase.insert("prueba",null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre","Sutano");
        cvDatos.put("apellido","Sanchez");
        sqLiteDatabase.insert("prueba",null,cvDatos);
        cvDatos.clear();
        long iClave;
        cvDatos.put("nombre","Ash");
        cvDatos.put("apellido","Ketchup");
        iClave = sqLiteDatabase.insert("prueba",null,cvDatos);
        Toast.makeText(this,iClave + "",Toast.LENGTH_SHORT).show();

        //UPDATE
        cvDatos.clear();
        cvDatos.put("nombre","Juanelo");
        String[] args = {iClave + ""};
        sqLiteDatabase.update("prueba",cvDatos,"id = ?",args);

        //DELETE
        String[] args2 = {"Luis"};
        sqLiteDatabase.delete("prueba","nombre = ?",args2);

        //Cursor cursor = sqLiteDatabase.rawQuery("select * from prueba;", null);
        String[] columns = {"id","nombre","apellido"};
        String[] args3 = {"Rodrigo"};
        Cursor cursor = sqLiteDatabase.query("prueba",columns,"nombre like ?",args3,null,null,"apellido");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            nombre.add(cursor.getString(cursor.getColumnIndex("nombre")) + " " + cursor.getString(cursor.getColumnIndex("apellido")));
            cursor.moveToNext();
        }
        lstDatos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombre));

    }
}