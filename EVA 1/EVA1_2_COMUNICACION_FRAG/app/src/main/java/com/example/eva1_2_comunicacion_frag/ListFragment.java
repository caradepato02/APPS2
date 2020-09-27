package com.example.eva1_2_comunicacion_frag;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;


public class ListFragment extends Fragment {
    String[] datos ={
            "Azul",
            "Morado",
            "Rojo",
            "Verde",
            "Amarillo",
            "Cafe",
            "Blanco",
            "Negro",
            "Gris",
            "Rosa",
            "Naranja",
            "Aqua",
            "Cyan",
            "Magenta",
    };
    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout = (FrameLayout)inflater.inflate(R.layout.fragment_list, container, false);
         ListView lstVwDatos = frameLayout.findViewById(R.id.lstVwDatos);
        lstVwDatos.setAdapter(new ArrayAdapter<>(
                main,
                android.R.layout.simple_list_item_1,
                datos
        ));
        lstVwDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                main.onMessageFromFragToMain("LISTA",datos[position]);
            }
        });
        return frameLayout;
    }
}