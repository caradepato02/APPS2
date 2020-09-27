package com.example.eva1_11_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class MainActivity extends AppCompatActivity {

    ListView lstVwClima;
    List<Weather> lstCiudades = new ArrayList<>();
    /*
    Weather[] cities =  {
      new Weather("Chihuahua", "Nublado", 18, R.drawable.cloudy),
            new Weather("Cuauhtemoc", "Lluvia Fuerte", 22, R.drawable.rainy),
            new Weather("Ciudad Juarez", "Nieve", 2, R.drawable.snow),
            new Weather("Delicias", "Tormentas dispersas", 26, R.drawable.thunderstorm),
            new Weather("Saucillo", "Nublado", 15, R.drawable.cloudy),
            new Weather("Camargo", "Soleado", 24, R.drawable.sunny),
            new Weather("Jimenez", "Alerta de Tornados", 10, R.drawable.tornado),
            new Weather("Parral", "Lluvia ligera", 16, R.drawable.light_rain),
            new Weather("Villa Ahumada", "Nieve", 1, R.drawable.snow),
            new Weather("Ojinaga", "Tormentas aisladas", 20, R.drawable.thunderstorm),
    };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstVwClima = findViewById(R.id.lstVwClima);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=439d4b804bc8187953eb36d2a8c26a02",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("list");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Weather wCiudad = new Weather();
                                wCiudad.setCity(jsonObject.getString("name"));
                                JSONObject jsMain = jsonObject.getJSONObject("main");
                                wCiudad.setTemp((int)jsMain.getDouble("temp"));

                                JSONArray jaClima = jsonObject.getJSONArray("weather");
                                JSONObject joClimaCiudad = jaClima.getJSONObject(0);
                                wCiudad.setDesc(joClimaCiudad.getString("description"));
                                int iId =joClimaCiudad.getInt("id");
                                if(iId < 300){//tormentas
                                    wCiudad.setImage(R.drawable.thunderstorm);
                                }else if(iId < 400){//Lluvia ligera
                                    wCiudad.setImage(R.drawable.light_rain);
                                }else if(iId < 600){//Lluvia intensa
                                    wCiudad.setImage(R.drawable.rainy);
                                }else if(iId < 700){//Nieve
                                    wCiudad.setImage(R.drawable.snow);
                                }else if(iId < 800){//Depejado
                                    wCiudad.setImage(R.drawable.sunny);
                                }else if(iId < 900){//Nublado
                                    wCiudad.setImage(R.drawable.cloudy);
                                }else{//Default
                                    wCiudad.setImage(R.drawable.tornado);
                                }

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        lstVwClima.setAdapter(new WeatherAdapter(MainActivity.this,R.layout.mi_layout,lstCiudades));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        Volley.newRequestQueue(this).add(jsonObjectRequest);
        //lstVwClima.setAdapter(new WeatherAdapter(this, R.layout.mi_layout, cities));
    }
}
