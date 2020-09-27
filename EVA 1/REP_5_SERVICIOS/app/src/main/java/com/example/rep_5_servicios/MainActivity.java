package com.example.rep_5_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnIniciar;
    Button btnDetener;
    Intent inServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inServicio = new Intent(this,MyService.class);
        btnDetener =  findViewById(R.id.btnDetener);
        btnIniciar =  findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(this);
        btnDetener.setOnClickListener(this);
        BroadcastReceiver bReceiver = new MibroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter("MI_SERVICIO");
        registerReceiver(bReceiver, intentFilter);
    }

    public void iniciar(View v){
        startService(inServicio);
        inServicio.putExtra("DATO","Hola");
    }

    public void detener(View v){
        stopService(inServicio);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciar:
                iniciar(v);
                break;
            case R.id.btnDetener:
                detener(v);
                break;
        }
    }

    class MibroadCastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.wtf("MENSAJE", "THREAD");
        }
    }
}