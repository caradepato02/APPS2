package com.example.exa1_calculo_areas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtVwArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwArea = findViewById(R.id.txtVwarea);
    }

    public void onMessageFromFragToMain(String frag, String param){
        if(frag == "LISTA") {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            switch (param) {
                case "Circulo":
                    CirculoFragment circuloFragment = new CirculoFragment();
                    ft.replace(R.id.frmLytFigura, circuloFragment);
                    break;
                case "Cometa":
                    CometaFragment cometaFragment = new CometaFragment();
                    ft.replace(R.id.frmLytFigura, cometaFragment);
                    break;
                case "Cuadrado":
                    CuadradoFragment cuadradoFragment = new CuadradoFragment();
                    ft.replace(R.id.frmLytFigura, cuadradoFragment);
                    break;
                case "Cubo":
                    CuboFragment cuboFragment = new CuboFragment();
                    ft.replace(R.id.frmLytFigura, cuboFragment);
                    break;
                case "Paralelgramo":
                    ParalelogramoFragment paralelogramoFragment = new ParalelogramoFragment();
                    ft.replace(R.id.frmLytFigura, paralelogramoFragment);
                    break;
                case "Poligono":
                    PoligonoFragment poligonoFragment = new PoligonoFragment();
                    ft.replace(R.id.frmLytFigura, poligonoFragment);
                    break;
                case "Rectangulo":
                    RectanguloFragment rectanguloFragment = new RectanguloFragment();
                    ft.replace(R.id.frmLytFigura, rectanguloFragment);
                    break;
                case "Rombo":
                    RmboFragment rmboFragment = new RmboFragment();
                    ft.replace(R.id.frmLytFigura, rmboFragment);
                    break;
                case "Triangulo":
                    TrianguloFragment trianguloFragment = new TrianguloFragment();
                    ft.replace(R.id.frmLytFigura, trianguloFragment);
                    break;
            }
            ft.commit();
            txtVwArea.setText("Area = ");
        }else if(frag == "FIGURA"){
            txtVwArea.setText("Area = " + param);
        }
    }

}
