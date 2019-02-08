package com.example.redes.leccionmoviles1;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Juego extends AppCompatActivity{
    ImageView mamifero1,mamifero2,mamifero3,insecto1,insecto2,insecto3;
    ImageView avatar;
    Intent intent1;
    Button validar;
    int mamiferototal, insectototal,m1,m2,m3,in1,in2,in3;
    boolean banm1,banm2,banm3,bani1,bani2,bani3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);

        intent1 = getIntent();
        Bitmap bitmap = intent1.getParcelableExtra("bitMap");
        avatar = (ImageView) findViewById(R.id.avatar);
        avatar.setImageBitmap(bitmap);
        validar = (Button) findViewById(R.id.validar);


        mamifero1 = (ImageView) findViewById(R.id.mamifero1);
        mamifero2 = (ImageView) findViewById(R.id.mamifero2);
        mamifero3 = (ImageView) findViewById(R.id.mamifero3);

        insecto1 = (ImageView) findViewById(R.id.insecto1);
        insecto2 = (ImageView) findViewById(R.id.insecto2);
        insecto3 = (ImageView) findViewById(R.id.insecto3);

        mamifero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(banm1==false){

                 mamifero1.setColorFilter(Color.argb(50, 0, 0, 0));
                 banm1 = true;
                 m1=1;
             }
             else if(banm1== true){
                 mamifero1.setColorFilter(Color.argb(0, 0, 0, 0));
                 banm1 = false;
                 m1=0;
             }


                //startActivity(intent1);
            }
        });

        mamifero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(banm2==false){

                    mamifero2.setColorFilter(Color.argb(50, 0, 0, 0));
                    banm2 = true;
                    m2=1;
                }
                else if(banm2== true){
                    mamifero2.setColorFilter(Color.argb(0, 0, 0, 0));
                    banm2 = false;
                    m2=0;
                }


                //startActivity(intent1);
            }
        });

        mamifero3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(banm3==false){

                    mamifero3.setColorFilter(Color.argb(50, 0, 0, 0));
                    banm3 = true;
                    m3=1;
                }
                else if(banm3== true){
                    mamifero3.setColorFilter(Color.argb(0, 0, 0, 0));
                    banm3 = false;
                    m3=0;
                }


                //startActivity(intent1);
            }
        });

        insecto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bani1==false){

                    insecto1.setColorFilter(Color.argb(50, 0, 0, 0));
                    bani1 = true;
                    in1=1;
                }
                else if(bani1== true){
                    insecto1.setColorFilter(Color.argb(0, 0, 0, 0));
                    bani1 = false;
                    in1=0;
                }


                //startActivity(intent1);
            }
        });

        insecto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bani2==false){

                    insecto2.setColorFilter(Color.argb(50, 0, 0, 0));
                    bani2 = true;
                    in2=1;
                }
                else if(bani2== true){
                    insecto2.setColorFilter(Color.argb(0, 0, 0, 0));
                    bani2 = false;
                    in2=0;
                }


                //startActivity(intent1);
            }
        });

        insecto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bani3==false){

                    insecto3.setColorFilter(Color.argb(50, 0, 0, 0));
                    bani3 = true;
                    in3=1;
                }
                else if(bani3== true){
                    insecto3.setColorFilter(Color.argb(0, 0, 0, 0));
                    bani3 = false;
                    in3=0;
                }


                //startActivity(intent1);
            }
        });



        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mamiferototal = m1+m2+m3;
            insectototal=in1+in2+in3;

               intent1 = new Intent(Juego.this, Resultado.class);
               // intent1.putExtra("mamiferototal",mamiferototal);
                intent1.putExtra("mamiferovar", mamiferototal);
                intent1.putExtra("insectovar", insectototal);



                startActivity(intent1);
            }
        });


    }
}
