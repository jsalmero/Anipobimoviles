 package com.example.redes.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
     int numero10000 = 1000;
 TextView resultado;
     private boolean flat;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = (TextView) findViewById(R.id.txtResultado);

    }

     public boolean primo() {
         int numero10000 =1000;
         for(int i=1; i<= 1000; i++){



         }
         resultado.setText();
     }

}

