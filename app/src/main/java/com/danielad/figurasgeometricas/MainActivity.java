package com.danielad.figurasgeometricas;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private double lado, radio, lado1, lado2, lado3;
    private double peri, area, volumen, semipe;
    private RadioButton rCuadro, rCirculo, rTriangulo, rCubo;
    private EditText eLado, eRadio, eLado1, eLado2, eLado3;
    private Button bCalcular;
    private TextView tResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rCuadro = (RadioButton) findViewById( R.id.rCuadro);
        rCirculo = (RadioButton) findViewById( R.id.rCirculo);
        rTriangulo = (RadioButton) findViewById( R.id.rTriangulo);
        rCubo = (RadioButton) findViewById( R.id.rCubo);
        eLado = (EditText) findViewById(R.id.eLado);
        eRadio = (EditText) findViewById(R.id.eRadio);
        eLado1 = (EditText) findViewById(R.id.eLado1);
        eLado2 = (EditText) findViewById(R.id.eLado2);
        eLado3 = (EditText) findViewById(R.id.eLado3);
        bCalcular = (Button) findViewById( R.id.bCalcular);
        tResult = (TextView) findViewById(R.id.tResult);

        rCuadro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eLado.setEnabled(true);
                eRadio.setEnabled(false);
                eLado1.setEnabled(false);
                eLado2.setEnabled(false);
                eLado3.setEnabled(false);

            }
        });

        rCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eLado.setEnabled(false);
                eRadio.setEnabled(true);
                eLado1.setEnabled(false);
                eLado2.setEnabled(false);
                eLado3.setEnabled(false);

            }
        });
        rTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eLado.setEnabled(false);
                eRadio.setEnabled(false);
                eLado1.setEnabled(true);
                eLado2.setEnabled(true);
                eLado3.setEnabled(true);

            }
        });
        rCubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eLado.setEnabled(true);
                eRadio.setEnabled(false);
                eLado1.setEnabled(false);
                eLado2.setEnabled(false);
                eLado3.setEnabled(false);

            }
        });




        bCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                if (rCuadro.isChecked()){
                    lado = Double.parseDouble(eLado.getText().toString());
                    peri = 4*lado;
                    area = lado*lado;
                    tResult.setText("El perímetro es: "+String.format("%.2f", peri)+" cm"+"\nEl area es: "+String.format("%.2f", area)+" cm^2");

                }
                if (rCirculo.isChecked()){
                    radio = Double.parseDouble(eRadio.getText().toString());
                    peri = 2*3.1416*radio;
                    int elevado = (int) Math.pow(radio,2);
                    area = elevado*3.1416;
                    tResult.setText("El perímetro es: "+String.format("%.2f", peri)+" cm"+"\nEl area es: "+String.format("%.2f", area)+" cm^2");

                }
                if (rTriangulo.isChecked()){
                    lado1 = Double.parseDouble(eLado1.getText().toString());
                    lado2 = Double.parseDouble(eLado2.getText().toString());
                    lado3 = Double.parseDouble(eLado3.getText().toString());
                    peri = lado1+lado2+lado3;
                    semipe = peri/2;
                    int elevado = (int) Math.pow(radio,2);
                    area = Math.sqrt(semipe*(semipe-lado1)*(semipe-lado2)*(semipe-lado3));


                    tResult.setText("El perímetro es: "+String.format("%.2f", peri)+" cm"+"\nEl área es: "+String.format("%.2f", area)+" cm^2");
                }
                if (rCubo.isChecked()){
                    lado = Double.parseDouble(eLado.getText().toString());
                    area = 6*lado*lado;
                    volumen = lado*lado*lado;
                    tResult.setText("El área total es: "+String.format("%.2f", area)+" cm^2"+ "\nEl volumen es: "+String.format("%.2f", volumen)+" cm^3");
                }

            }
        });

    }
}
