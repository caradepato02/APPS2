package com.example.eva1_11_clima;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends ArrayAdapter <Weather> {
    //Weather []  objects;
    private List<Weather> objects;
    private Context context;
    private int resource;

    public WeatherAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            //Primera vez, hay que crear el layout
        convertView = ((Activity) context).getLayoutInflater().inflate(resource, parent, false);
        }

        //Hay que recuperar los componentes
        ImageView imgIcon;
        TextView txtCity,txtTemp, txtDesc;

        imgIcon = convertView.findViewById(R.id.imgIcon);
        txtCity = convertView.findViewById(R.id.txtCity);
        txtTemp = convertView.findViewById(R.id.txtTemp);
        txtDesc = convertView.findViewById(R.id.txtDesc);

        Weather weather = objects.get(position);
        imgIcon.setImageResource(weather.getImage());
        txtCity.setText(weather.getCity());
        txtTemp.setText("" +weather.getTemp()+" °C");
        txtDesc.setText(weather.getDesc());

        return convertView;

       // return super.getView(position, convertView, parent);
    }



}
