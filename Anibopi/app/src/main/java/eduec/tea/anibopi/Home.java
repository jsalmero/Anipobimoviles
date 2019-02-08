package eduec.tea.anibopi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

public class Home extends AppCompatActivity {

    private ImageView btnatras, btnevaluacion, btnplanta, btnanimal, btnroca, btnmontana;
    public Intent intent;
    public static int acierto, equivocacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnevaluacion = (ImageView) findViewById(R.id.btnEvaluacion);
        btnatras = (ImageView) findViewById(R.id.btatras);
        btnplanta = (ImageView) findViewById(R.id.planta);
        btnanimal = (ImageView) findViewById(R.id.animal);
        btnroca = (ImageView) findViewById(R.id.roca);
        btnmontana = (ImageView) findViewById(R.id.montana);
        new SendPostRequest().execute();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    intent = new Intent(getApplicationContext(), Inicio.class);
                    startActivity(intent);
                }finally {
                    finish();
                }
            }
        });

        btnevaluacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    intent = new Intent(getApplicationContext(), ActividadEvaluacion.class);
                    startActivity(intent);
                }finally {
                    finish();
                }
            }
        });

        btnplanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    intent = new Intent(getApplicationContext(), VideoPlantas.class);
                    startActivity(intent);
                }finally {
                    finish();
                }
            }
        });

        btnanimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    intent = new Intent(getApplicationContext(), VideoAnimales.class);
                    startActivity(intent);
                }finally {
                    finish();
                }
            }
        });

        btnroca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    intent = new Intent(getApplicationContext(), VideoRocas.class);
                    startActivity(intent);
                }finally {
                    finish();
                }
            }
        });

        btnmontana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    intent = new Intent(getApplicationContext(), VideoMontanas.class);
                    startActivity(intent);
                }finally {
                    finish();
                }
            }
        });

    }

    void kill_activity(){finish();}

    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("https://webservicemoviles.000webhostapp.com/insertarAnibopi.php"); // here is your URL path

                JSONObject postDataParams = new JSONObject();
               // String a= Integer.toString(acierto);
               // String e= Integer.toString(equivocacion);
                postDataParams.put("acierto", acierto);
                postDataParams.put("equivocacion", equivocacion);
                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new
                            InputStreamReader(
                            conn.getInputStream()));

                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }

        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), "Guardado "+equivocacion,
                    Toast.LENGTH_LONG).show();
        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

}
