package com.example.exa1_calculo_areas;

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
    String[] figuras ={
            "Circulo",
            "Cometa",
            "Cuadrado",
            "Cubo",
            "Paralelgramo",
            "Poligono",
            "Rectangulo",
            "Rombo",
            "Trapecio",
            "Triangulo"
    };
    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout = (FrameLayout)inflater.inflate(R.layout.fragment_list, container, false);
        ListView lstVwDatos = frameLayout.findViewById(R.id.lstVwFiguras);
        lstVwDatos.setAdapter(new ArrayAdapter<>(
                main,
                android.R.layout.simple_list_item_1,
                figuras
        ));
        lstVwDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                main.onMessageFromFragToMain("LISTA",figuras[position]);
            }
        });
        return frameLayout;
    }

}