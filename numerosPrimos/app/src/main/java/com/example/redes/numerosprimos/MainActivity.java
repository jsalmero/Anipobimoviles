package com.example.redes.numerosprimos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int limite;
    public TextView primos;
    public Button button;
    int max = 500;
    int j = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primos= (TextView) findViewById(R.id.primos);
        button= (Button) findViewById(R.id.button);
        //limite=1000000;

        limite=10000000;
        for(int i=1;i<=limite;i++)
        {
            if(esPrimo(i))
            {
                System.out.println("Numero Primo:"+i);
                primos.setText(i+"");
            }
        }

        /*button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                for (int i = j; i <= max; i++) {
                    if (isPrimeNumber(i)) {
                        primos.setText(i+"");
                        j = i+1;
                        break;
                    }
                }

            }
        });*/

    }

    public boolean isPrimeNumber(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }






    public boolean esPrimo(int numero)
    {
        int aux;
        for(int cont=2;cont<numero;cont++)
        {
            aux=numero%cont;
            if(aux==0)
                return false;
        }
        return true;
    }



    }
g


