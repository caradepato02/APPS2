package com.example.rep_6_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.fancy);
    }

    public void iniciar(View v){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public void detener(View v){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }

}