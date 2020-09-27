package com.example.rep_7_mediaplayer_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,MyMusicPlayer.class);
    }

    public void iniciar(View v){
        startService(intent);
    }

    public void detener(View v){
        stopService(intent);
    }
}