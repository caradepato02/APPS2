package com.example.exa1_mostrarimagenes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Thread hilito;
    long velocidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        velocidad = 1000;
    }

    @Override
    protected void onStart() {
        super.onStart();
        hilito = new Thread(new Runnable() {
            @Override
            public void run() {
                int imagen = 0;
                boolean reversa =false;
                while(true) {
                    imgFrag2.onMessageFromMainToFrag(imagen);
                    if (imgFrag1 != null && imgFrag3 != null) {
                        imgFrag1.onMessageFromMainToFrag(imagen - 1);
                        imgFrag3.onMessageFromMainToFrag(imagen + 1);
                    }
                    if(imagen < 107 && !reversa){
                        imagen++;
                    }else if(imagen > 0){
                        imagen--;
                        reversa = true;
                    }else{
                        reversa = false;
                    }
                    try {
                        Thread.sleep(velocidad);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        hilito.start();
    }

    BarSeekFragment barrita;
    ImageFragment imgFrag1;
    ImageFragment imgFrag2;
    ImageFragment imgFrag3;

    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == BarSeekFragment.class){
            barrita = (BarSeekFragment) fragment;
        }else if(fragment.getClass() == ImageFragment.class){
            if(fragment.getId() == R.id.imgFrag1){
                imgFrag1 = (ImageFragment) fragment;
                //imgFrag1.onMessageFromMainToFrag(0);
            }else if(fragment.getId() == R.id.imgFrag2){
                imgFrag2 = (ImageFragment) fragment;
                //imgFrag2.onMessageFromMainToFrag(1);
            }else if(fragment.getId() == R.id.imgFrag3) {
                imgFrag3 = (ImageFragment) fragment;
                //imgFrag3.onMessageFromMainToFrag(2);
            }
        }
    }


    public void onMessageFromFragToMain(String sender,int param){
        if (sender.equals("BARRITA")){
            velocidad = 1000 - param;
        }
    }



}