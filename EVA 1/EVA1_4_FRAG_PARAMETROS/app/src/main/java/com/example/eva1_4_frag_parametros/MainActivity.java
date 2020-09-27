package com.example.eva1_4_frag_parametros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearFragment(View v){
        //Transacion
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //Crear fragmento
        ParamFragment paramFragment = ParamFragment.newInstance("Hola mundo","Valores del fragmento");
        //Reemplazaar el layout
        ft.replace(R.id.frmLytFrag,paramFragment);
        //Commit
        ft.commit();
    }
}