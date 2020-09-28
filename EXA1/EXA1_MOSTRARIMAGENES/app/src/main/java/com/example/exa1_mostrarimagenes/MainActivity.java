package com.example.exa1_mostrarimagenes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            imgFrag2.onMessageFromMainToFrag(param);
            if(imgFrag1 != null && imgFrag3 != null) {
                imgFrag1.onMessageFromMainToFrag(param - 1);
                imgFrag3.onMessageFromMainToFrag(param + 1);
            }
        }
    }

}