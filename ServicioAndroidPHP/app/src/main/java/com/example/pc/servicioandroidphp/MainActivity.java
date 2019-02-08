package com.example.pc.servicioandroidphp;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    EditText editText, editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    public String enviarDatosGET(String datos_correctos, String datos_incorrectos) {
        String linea = "";
        URL url = null;

        int respuesta = 0;
        StringBuilder resul = null;

        try {
            url = new URL("http://192.168.56.1/Anibopi/ws/archivo.php?datos_correctos=" + datos_correctos + "&datosincorrectos=" + datos_incorrectos);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            respuesta = connection.getResponseCode();
            resul = new StringBuilder();


            resul = new StringBuilder();
            if (respuesta == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea = reader.readLine()) != null) {
                    resul.append(linea);
                }
            }
        } catch (Exception e) {
        }

        return resul.toString();
    }

    public int obtDatosJSON(String response) {
        int res = 0;
        try {
            JSONArray json = new JSONArray(response);
            res = 1;
        } catch (Exception e) {
        }
        return res;
    }

    @Override
    public void onClick(View v) {
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String resultado = enviarDatosGET(editText.getText().toString(), editText2.getText().toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJSON(resultado);
                        if (r > 0) {
                            Intent i = new Intent(getApplicationContext(), actividadnotas.class);
                            i.putExtra("cod", editText.getText().toString());
                        } else {
                            Toast.makeText(getApplicationContext(), "Usuarios o Pas Incorrectos", Toast.LENGTH_LONG);
                        }
                    }
                });
            }
        };
        tr.start();
    }




}
