package com.example.exa1_calculo_areas;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;


public class CometaFragment extends Fragment {

    EditText d1;
    EditText d2;
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
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_cometa, container, false);
        d1 = linearLayout.findViewById(R.id.edtTxtD1);
        d2 = linearLayout.findViewById(R.id.edtTxtD2);
        return linearLayout;
    }



    public void calcularArea(View v) {
        double area = Math.pow(Integer.valueOf(d1.getText().toString()),2)*Math.PI;
        main.onMessageFromFragToMain("FIGURA",String.valueOf(area));
    }
}