package com.example.eva1_2_comunicacion_frag;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DataFragment extends Fragment {
    TextView txtDatos;
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
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.fragment_data, container, false);
        Button btnDatos = linearLayout.findViewById(R.id.btnDatos);
        txtDatos = linearLayout.findViewById(R.id.txtVwDatos);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMessageFromFragToMain("DATA","Mensaje del fragment de datos");
            }
        });
        return linearLayout;
    }

    public void onMessageFromMainToFrag(String param){
        txtDatos.setText(param);
    }
}