package com.example.redes.primos2;

import android.support.v7.app.AppCompatActivity;


import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//new MainActivity().execute(String, Float, Integer);
//public class MainActivity extends AsyncTask <String, Float, Integer> {

public class MainActivity extends Activity implements View.OnClickListener {

    Button btn;
    public String limite;
            public int finalnum;
    public TextView primos;
    public Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primos= (TextView) findViewById(R.id.view);
        limite="Johana";

        //  button= (Button) findViewById(R.id.button);
        // btn = (Button) findViewById(R.id.button1);
        // because we implement OnClickListener we only have to pass "this"
        // (much easier)
        //btn.setOnClickListener(this);
        new LongOperation().execute("");
    }

    public void onClick(View view) {


    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 1; i++) {
                limite = "Johana";
                try {
                    if(esPrimo(i))
                    {
                        System.out.println("Nombre:"+limite);

                        finalnum= i;
                    }

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }

            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            TextView txt = (TextView) findViewById(R.id.view);
            txt.setText("Executed"); // txt.setText(result);
            primos.setText("" +limite);

            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
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