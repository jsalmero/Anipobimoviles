package com.example.redes.leccionmoviles1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView avatar1,avatar2,avatar3;
    Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avatar1 = (ImageView) findViewById(R.id.avatar1);
        avatar2 = (ImageView) findViewById(R.id.avatar2);
        avatar3 = (ImageView) findViewById(R.id.avatar3);

        avatar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent1=new Intent(getApplicationContext(),Juego.class);
                Bitmap bitmap = ((BitmapDrawable)avatar1.getDrawable()).getBitmap();
                 intent1 = new Intent(MainActivity.this, Juego.class);
                intent1.putExtra("bitMap",bitmap);

                startActivity(intent1);
            }
        });

        avatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent1=new Intent(getApplicationContext(),Juego.class);
                Bitmap bitmap = ((BitmapDrawable)avatar2.getDrawable()).getBitmap();
                intent1 = new Intent(MainActivity.this, Juego.class);
                intent1.putExtra("bitMap",bitmap);

                startActivity(intent1);
            }
        });

        avatar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent1=new Intent(getApplicationContext(),Juego.class);
                Bitmap bitmap = ((BitmapDrawable)avatar3.getDrawable()).getBitmap();
                intent1 = new Intent(MainActivity.this, Juego.class);
                intent1.putExtra("bitMap",bitmap);

                startActivity(intent1);
            }
        });

    }
}
