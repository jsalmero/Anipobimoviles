package eduec.tea.anibopi;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    private VideoView videoView;
    // private ImageView repetir;
    private int position = 0;
    public Intent intent;
    private MediaController mediaController;
    private Image buttonPause;
    public int cont=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //this.buttonPause= (Image)this.findViewById(R.id.imageView);

        //this.buttonPause.setEnabled(false);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        videoView = (VideoView) findViewById(R.id.videoView);
        // repetir = (ImageView) findViewById(R.id.btnrepetir);

        //  repetir.setVisibility(View.INVISIBLE);

        // Set the media controller buttons
        if (mediaController == null) {
            mediaController = new MediaController(Video.this);

            // Set the videoView that acts as the anchor for the MediaController.
            mediaController.setAnchorView(videoView);
            // Set MediaController for VideoView
            videoView.setMediaController(mediaController)

            ;/*
            repetir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    videoView.resume();
                }
            });*/


        }




        try {
            // ID of video file.
            int id = this.getRawResIdByName("introvideo");
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoView.requestFocus();


        // When the video file ready for playback.
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();

                }

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView that acts as the anchor for the MediaController
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                // repetir.setVisibility(View.VISIBLE);
                //cont++;

                try {
                    intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                }finally {
                    finish();
                }

            }
        });



    }

    void kill_activity(){finish();}

    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
    

}
