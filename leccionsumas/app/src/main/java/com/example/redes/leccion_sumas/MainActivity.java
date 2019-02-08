package com.example.redes.leccion_sumas;
import android.R;
import android.R.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button button;
    EditText editText;
    public  MediaPlayer correcto,incorrecto;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context =getApplicationContext();

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(this);
        correcto = MediaPlayer.create(this, R.raw.incorrecto1selplanta);


    }

    public void onClick (View v){
        int valor = Integer.parseInt(editText.getText().toString());
        int r= 5;
        if (r == valor){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT);
            toast1.show();

            correcto = MediaPlayer.create(this, R.raw.correcto1selplanta);
        }
        else{
            Toast toast2 = Toast.makeText(getApplicationContext(), "Intente de Nuevo", Toast.LENGTH_SHORT);
            toast2.show();
        }
    }
}
