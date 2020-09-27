package com.example.eva1_5_cambio_orientacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout frmLytDetail;
    Intent inDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inDetail = new Intent(this,DetailActivity.class);
    }

    public void onMessageFromFragmentToMain(){
        frmLytDetail = findViewById(R.id.frmLytDetail);
        if(frmLytDetail != null){//Landscape
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            DetailFragment detailFragment = new DetailFragment();
            ft.replace(R.id.frmLytDetail,detailFragment);
            ft.commit();
        }else{//Portrait
            startActivity(inDetail);
        }
    }

}