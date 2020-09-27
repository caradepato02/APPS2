package com.example.rep_1_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwDatos;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            txtVwDatos.append("Hola mundito \n");
        }
    };

    Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();
            int i = 0;
            while(i<100){
                try {
                    Thread.sleep(1000);
                    runOnUiThread(runnable);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                i++;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos = findViewById(R.id.texto);
        thread.start();
    }
}
