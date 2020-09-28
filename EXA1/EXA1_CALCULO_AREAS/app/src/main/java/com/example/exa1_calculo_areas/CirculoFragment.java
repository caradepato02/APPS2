package com.example.exa1_calculo_areas;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class CirculoFragment extends Fragment{
    EditText radio;
    Button boton;
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
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_circulo, container, false);
        boton = linearLayout.findViewById(R.id.btnCirculo);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularArea();
            }
        });
        radio = linearLayout.findViewById(R.id.edtTxtRadio);
        return linearLayout;
    }

    public void calcularArea() {
       double area = Math.pow(Integer.valueOf(radio.getText().toString()),2)*Math.PI;
       main.onMessageFromFragToMain("FIGURA",String.valueOf(area));
    }
}