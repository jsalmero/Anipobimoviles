package com.example.redes.numerosprimos_asynctask;

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

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
           // btn = (Button) findViewById(R.id.button1);
            // because we implement OnClickListener we only have to pass "this"
            // (much easier)
            //btn.setOnClickListener(this);
            new LongOperation().execute("");
        }

        public void onClick(View view) {
            // detect the view that was "clicked"
           /* switch (view.getId()) {
                case R.id.button1:
                    new LongOperation().execute("");
                    break;
            }*/
        }

        private class LongOperation extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                }
                return "Executed";
            }

            @Override
            protected void onPostExecute(String result) {
                TextView txt = (TextView) findViewById(R.id.view1);
                txt.setText("Executed"); // txt.setText(result);
                // might want to change "executed" for the returned string passed
                // into onPostExecute() but that is upto you
            }

            @Override
            protected void onPreExecute() {}

            @Override
            protected void onProgressUpdate(Void... values) {}
        }
    }
/*
public class MainActivity extends AsyncTask<Void, Integer, Boolean> {

    public int limite;

        @Override
        protected Boolean doInBackground(Void... params) {
            limite=10000000;
            for(int i=1; i<=limite; i++) {
                //tareaLarga();
                System.out.println("Numero Primo:"+i);
               // publishProgress(i*10);

                if(isCancelled())
                    break;
            }

            return true;


        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            int progreso = values[0].intValue();

          //  pbarProgreso.setProgress(progreso);
         //   Toast.makeText(MainHilos.this, "Tarea finalizada!";


        }



        @Override
        protected void onPreExecute() {
          //  pbarProgreso.setMax(100);
            //pbarProgreso.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            //if(result)
                //Toast.makeText(MainActivity.this, "Tarea finalizada!"
                        //Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onCancelled() {
          //  Toast.makeText(MainHilos.this, "Tarea cancelada!",
                 //   Toast.LENGTH_SHORT).show();
        }
    }
*/