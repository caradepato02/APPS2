package com.example.exa1_mostrarimagenes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

public class ImageFragment extends Fragment {
    ImageView imgVwImagen;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_image, container, false);
        imgVwImagen = linearLayout.findViewById(R.id.imgVwImagen);
        imgVwImagen.setImageResource(R.drawable.palomita_031);
        return linearLayout;
    }

    public void onMessageFromMainToFrag(int param){
        String nombre;
        if(param > 67){
            nombre = "palomita_" + (32 + param);
        }else{
            nombre = "palomita_0" + (32 + param);
        }

        int idImagen = getResId(nombre,R.drawable.class);
        imgVwImagen.setImageResource(idImagen);
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    }