package com.example.eva2_16_mysqlite_2;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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

        sqLiteDatabase.beginTransaction();

        try {
            sqLiteDatabase.execSQL("insert into prueba(nombre,apellido) values('Rodrigo','Reyes')");
            sqLiteDatabase.execSQL("insert into prueba(nombre,apellido) values('Alondra','Ruiz')");
            //int i = 1/0;
            sqLiteDatabase.execSQL("insert into prueba(nombre,apellido) values('Luis','Anchondo')");
            sqLiteDatabase.execSQL("insert into prueba(nombre,apellido) values('Francisco','Acosta')");
            sqLiteDatabase.execSQL("insert into prueba(nombre,apellido) values('Sutano','Sanchez')");
            sqLiteDatabase.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.endTransaction();
        }

        Cursor cursor = sqLiteDatabase.rawQuery("select * from prueba;", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            nombre.add(cursor.getString(cursor.getColumnIndex("nombre")) + " " + cursor.getString(cursor.getColumnIndex("apellido")));
            cursor.moveToNext();
        }
        lstDatos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombre));
    }
}