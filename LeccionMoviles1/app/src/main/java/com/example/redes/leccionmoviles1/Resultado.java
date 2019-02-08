package com.example.redes.leccionmoviles1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Resultado extends AppCompatActivity {

    Intent intent1;

    TextView mamiferos,insectos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        mamiferos = (TextView) findViewById(R.id.mamiferos);
        insectos = (TextView) findViewById(R.id.insectos);


        //intent1 = getIntent();
       // Integer m = intent1.getIntExtra("variable_integer", mamiferototal);
        intent1 = getIntent(); int m = intent1.getIntExtra("mamiferovar", 0);
        // String recuperamos_variable_string = getIntent().getStringExtra("variable_string");
        intent1 = getIntent(); int i = intent1.getIntExtra("insectovar", 0);

        //mamiferos = (TextView) findViewById(R.id.mamiferos);
        mamiferos.setText(m+" mamiferos");
        insectos.setText(i+" insectos");


    }
}
