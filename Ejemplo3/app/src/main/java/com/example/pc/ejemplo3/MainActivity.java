package com.example.pc.ejemplo3;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MainActivity extends Activity {
    ImageView imageView;
   private Bitmap loadedImage;
    private String imageHttpAddress ="http://jonsegador.com/wp-content/apezz.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
    downloadFile(imageHttpAddress);
    }

    private void downloadFile(String imageHttpAddress) {
        URL imageUrl = null;
        try{
            imageUrl =new URL(imageHttpAddress);
            HttpURLConnection conn =(HttpURLConnection) imageUrl.openConnection();
        }
        catch (IOException e){
            Toast.makeText(getApplicationContext(), "Error:" +e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


}







